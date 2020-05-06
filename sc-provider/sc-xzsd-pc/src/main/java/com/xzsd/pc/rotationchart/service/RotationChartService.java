package com.xzsd.pc.rotationchart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.rotationchart.dao.RotationChartDao;
import com.xzsd.pc.rotationchart.entity.RCGoodsVO;
import com.xzsd.pc.rotationchart.entity.RotationChartInfo;
import com.xzsd.pc.rotationchart.entity.RotationChartVO;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 轮播图管理模块
 * @author asus
 */
@Service
public class RotationChartService {
    @Resource
    private RotationChartDao rotationChartDao;

    /**
     * 新增轮播图
     * @param rotationChartInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addRotationChart(RotationChartInfo rotationChartInfo){
        //校验序号跟商品编号
        int count = rotationChartDao.countSortOrdinal(rotationChartInfo);
        if(0 != count){
            return AppResponse.bizError("新增轮播图失败,该序号已存在,或该商品编号的轮播图已存在");
        }
        //设置轮播图信息
        rotationChartInfo.setStatus(-1);
        rotationChartInfo.setRotationChartCode(StringUtil.getCommonCode(6));
        rotationChartInfo.setIsDelete(0);
        if (rotationChartInfo.getImage() == null || "".equals(rotationChartInfo.getImage())){

            rotationChartInfo.setImage("https://book-store-1300963863.cos.ap-guangzhou.myqcloud.com/book-store/2020/2/29/223ceba3-59e0-419f-a306-5c3a5d363bbc.ico");
        }
        //新增轮播图
        int result = rotationChartDao.addRotationChart(rotationChartInfo);
        if ( 0 == result){
            return AppResponse.bizError("新增轮播图失败");
        }
        return AppResponse.success("新增轮播图成功");
    }

    /**
     * 查询商品列表
     * @param rcGoodsVO
     * @return
     */
    public AppResponse listGoods(RCGoodsVO rcGoodsVO){
        PageHelper.startPage(rcGoodsVO.getPageNum(),rcGoodsVO.getPageSize());
        List<RCGoodsVO> listGoods = rotationChartDao.listGoods(rcGoodsVO);
        PageInfo<RCGoodsVO> pageInfo = new PageInfo<>(listGoods);
        return AppResponse.success("查询商品列表成功",pageInfo);
    }

    /**
     * 查询轮播图详情
     * @param rotationChartCode
     * @return
     */
    public AppResponse getRotationChart(String rotationChartCode){
        RotationChartVO rotationChartVO = rotationChartDao.getRotationChart(rotationChartCode);
        return AppResponse.success("查询轮播图详情成功!",rotationChartVO);
    }

    /**
     * 查询轮播图列表
     * @param rotationChartInfo
     * @return
     */
    public AppResponse listRotationChart(RotationChartInfo rotationChartInfo){
        PageHelper.startPage(rotationChartInfo.getPageNum(),rotationChartInfo.getPageSize());
        List<RotationChartVO> rotationChartInfoList = rotationChartDao.listRotationChart(rotationChartInfo);
        PageInfo<RotationChartVO> pageInfo = new PageInfo<>(rotationChartInfoList);

        return AppResponse.success("查询轮播图列表成功!",pageInfo);
    }
    /**
     * 删除轮播图
     * @param rotationChartCode
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteRotationChart(String rotationChartCode , String updater){
        List<String> rotationChartCodeList = Arrays.asList(rotationChartCode.split(","));
        int result = rotationChartDao.deleteRotationChart(new CodeList(updater,rotationChartCodeList));
        if (0 == result){
            return AppResponse.bizError("删除轮播图失败");
        }
        return AppResponse.success("删除轮播图成功");
    }

    /**
     * 修改轮播图状态
     * @param rotationChartCode
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateRotationChartState(String rotationChartCode , String status , String updater){
        if (Integer.parseInt(status) != -1 && Integer.parseInt(status) != 1){
            return AppResponse.bizError("修改轮播图状态失败,参数 status 错误,1 启用 -1禁用");
        }
        List<String> rotationChartCodeList = Arrays.asList(rotationChartCode.split(","));
        int result = rotationChartDao.updateRotationChartState(new CodeList(updater,rotationChartCodeList ,status));
        if (0 == result){
            return AppResponse.bizError("修改轮播图状态失败");
        }
        return AppResponse.success("修改轮播图状态成功");
    }
}
