package com.xzsd.pc.hotgoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsVO;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 热门商品管理模块
 * @author zehong
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * 设置热门商品展示数量
     * @param updater
     * @param displayCount
     * @param version
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse setDisplayCount(String updater,String displayCount,int version){
       int result =  hotGoodsDao.setDisplayCount(updater,displayCount,version);
       if(0 == result){
           return AppResponse.bizError("设置失败");
       }
       return AppResponse.success("设置成功");
    }

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        //校验序号跟商品编号是否已存在
        int countGoods = hotGoodsDao.countGoods(hotGoodsInfo.getGoodsCode());
        if(0 != countGoods){
            return AppResponse.bizError("新增热门商品失败，该商品已存在！");
        }
        int countSort = hotGoodsDao.countSort(hotGoodsInfo.getSortOrdinal());
        if(0 != countSort){
            return AppResponse.bizError("新增热门商品失败，该序号已存在！");
        }
        //设置热门商品信息
        hotGoodsInfo.setHotGoodsCode(StringUtil.getCommonCode(6));
        hotGoodsInfo.setIsDelete(0);
        //新增热门商品
        int result = hotGoodsDao.addHotGoods(hotGoodsInfo);
        if(0 == result){
            return AppResponse.bizError("新增热门商品失败！");
        }
        return AppResponse.success("新增热门商品成功！");
    }

    /**
     * 查询热门商品详情
     * @param hotGoodsCode
     * @return
     */
    public AppResponse getHotGoods(String hotGoodsCode){
        HotGoodsVO hotGoodsVO = hotGoodsDao.getHotGoods(hotGoodsCode);
        return AppResponse.success("查询热门商品详情成功",hotGoodsVO);
    }
    /**
     * 修改热门商品信息
     * @param hotGoodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        //校验序号跟商品编号是否已存在
        //获取原序号跟商品编号
        HotGoodsVO hotGoodsVO = hotGoodsDao.getHotGoods(hotGoodsInfo.getHotGoodsCode());
        //如果序号改了
        if (hotGoodsVO.getSortOrdinal()!=hotGoodsInfo.getSortOrdinal()){
            int countSort = hotGoodsDao.countSort(hotGoodsInfo.getSortOrdinal());
            if (0 != countSort){
                return AppResponse.bizError("修改热门商品失败，该序号已存在！");
            }
        }
        //如果商品改了
        if (!hotGoodsVO.getGoodsCode().equals(hotGoodsInfo.getGoodsCode())){
            int countGoods = hotGoodsDao.countGoods(hotGoodsInfo.getGoodsCode());
            if (0 != countGoods){
                return AppResponse.bizError("修改热门商品失败，该商品已存在！");
            }
        }
        int result = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if(0 == result){
            return AppResponse.bizError("修改热门商品失败");
        }
        return AppResponse.success("修改热门商品成功");
    }

    /**
     * 查询热门商品列表
     * @param hotGoodsInfo
     * @return
     */
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        PageHelper.startPage(hotGoodsInfo.getPageNum(),hotGoodsInfo.getPageSize());
        List<HotGoodsVO> hotGoodsVOList = hotGoodsDao.listHotGoods(hotGoodsInfo);
        PageInfo<HotGoodsVO> pageData = new PageInfo<>(hotGoodsVOList);

        return AppResponse.success("查询热门商品列表成功",pageData);
    }

    /**
     * 删除热门商品信息
     * @param hotGoodsCode
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotGoodsCode,String updater){
        List<String> hotGoodsCodeList = Arrays.asList(hotGoodsCode.split(","));
        int result = hotGoodsDao.deleteHotGoods(new CodeList(updater,hotGoodsCodeList));
        if(0 == result){
            return AppResponse.bizError("删除热门商品失败");
        }
        return AppResponse.success("删除热门商品成功");
    }


}

