package com.xzsd.app.customer.shopcart.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.goodsDetail.dao.GoodsDetailDao;
import com.xzsd.app.customer.goodsDetail.entity.GoodsVO;
import com.xzsd.app.customer.shopcart.dao.ShopCartDao;
import com.xzsd.app.customer.shopcart.entity.ShopCartGoodsInfo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 购物车管理模块
 */
@Service
public class ShopCartService {
    @Resource
    private ShopCartDao shopCartDao;
    @Resource
    private GoodsDetailDao goodsDetailDao;
    /**
     * 查询购物车内商品列表
     * @param userCode
     * @return
     */
    public AppResponse listGoodsByPage(String userCode){
        List<ShopCartGoodsInfo> goodsInfoList = shopCartDao.listGoodsByPage(userCode);
        return AppResponse.success("查询购物车内商品列表成功！",getPageInfo(goodsInfoList));
    }

    /**
     * 修改商品数量
     * @param shopCartGoodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsCount(ShopCartGoodsInfo shopCartGoodsInfo){
        //获取商品信息
        GoodsVO goodsVO = goodsDetailDao.getGoods(shopCartGoodsInfo.getGoodsCode());
        if (goodsVO.getStock() < shopCartGoodsInfo.getGoodsCount()){
            return AppResponse.bizError("修改商品数量失败,数量超出上限！");
        }
        //修改总价
        shopCartGoodsInfo.setSumPrice(goodsVO.getSellPrice()*shopCartGoodsInfo.getGoodsCount());
        int count = shopCartDao.updateGoodsCount(shopCartGoodsInfo);
        if (0 == count){
            return AppResponse.bizError("修改商品数量失败！");
        }
        return AppResponse.success("修改商品数量成功！");
    }

    /**
     * 将商品移出购物车
     * @param shopCartCode
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String shopCartCode, String updater){
        List<String> shopCartCodeList = Arrays.asList(shopCartCode.split(","));
        int count = shopCartDao.deleteGoods(shopCartCodeList,updater);
        if (0 == count){
            return AppResponse.bizError("删除商品失败！");
        }
        return AppResponse.success("删除商品成功！");
    }
}
