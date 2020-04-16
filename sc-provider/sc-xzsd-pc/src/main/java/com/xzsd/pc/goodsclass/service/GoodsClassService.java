package com.xzsd.pc.goodsclass.service;

import com.xzsd.pc.goodsclass.dao.GoodsClassDao;
import com.xzsd.pc.goodsclass.entity.GoodsClassInfo;
import com.xzsd.pc.goodsclass.entity.GoodsClassOne;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类管理模块
 * @author zehong
 */
@Service
public class GoodsClassService {
    @Resource
    private GoodsClassDao goodsClassDao;

    /**
     * 新增商品分类
     * @param goodsClassInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsClass(GoodsClassInfo goodsClassInfo){
        //设置分类信息
        goodsClassInfo.setClassCode(StringUtil.getCommonCode(6));
        goodsClassInfo.setIsDelete(0);
        //新增商品分类
        int result = goodsClassDao.addGoodsClass(goodsClassInfo);
        if (0 == result){
            return AppResponse.bizError("新增商品分类失败!");
        }
        return AppResponse.success("新增商品分类成功!");
    }

    /**
     * 查询分类详情
     * @param goodsClassInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getGoodsClass(GoodsClassInfo goodsClassInfo){
        GoodsClassInfo goodsClass = goodsClassDao.getGoodsClass(goodsClassInfo);
        return AppResponse.success("查询商品分类成功",goodsClass);
    }

    /**
     * 修改商品分类
     * @param goodsClassInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsClass(GoodsClassInfo goodsClassInfo){
        int result = goodsClassDao.updateGoodsClass(goodsClassInfo);
        if (0 == result){
            return AppResponse.bizError("修改商品分类失败!");
        }
        return AppResponse.success("修改商品分类成功");
    }

    /**
     * 查询分类列表
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listGoodsClass(){
        List<GoodsClassOne> goodsClassOneList = goodsClassDao.listGoodsClass();
        return AppResponse.success("查询商品分类列表成功",goodsClassOneList);
    }

    /**
     * 删除商品分类
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsClass(GoodsClassInfo goodsClassInfo){
        //检查该分类下是否有二级分类
        int count = goodsClassDao.countChildClass(goodsClassInfo.getClassCode());
        if (0 != count){
            return AppResponse.bizError("删除商品一级分类失败，该一级分类下有二级分类！");
        }
        //删除商品分类
        int result = goodsClassDao.deleteGoodsClass(goodsClassInfo);
        if (0 == result){
            return AppResponse.bizError("删除商品分类失败,该商品分类不存在！");
        }
        return  AppResponse.success("删除商品分类成功！");
    }
}
