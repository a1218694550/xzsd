package com.xzsd.app.customer.shopcart.dao;

import com.xzsd.app.customer.goodsDetail.entity.OpeGoods;
import com.xzsd.app.customer.shopcart.entity.ShopCartGoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车模块
 */
@Mapper
public interface ShopCartDao {
    /**
     * 查询购物车内商品列表
     * @param userCode
     * @return
     */
    List<ShopCartGoodsInfo> listGoodsByPage(@Param("userCode") String userCode);

    /**
     * 查询购物车内商品信息
     * @param opeGoods
     * @return
     */
    ShopCartGoodsInfo getGoodsForCart(OpeGoods opeGoods);
    /**
     * 修改商品数量
     * @param shopCartGoodsInfo
     * @return
     */
    int updateGoodsCount(ShopCartGoodsInfo shopCartGoodsInfo);

    /**
     * 将商品移出购物车
     * @param shopCartCodeList
     * @param updater
     * @return
     */
    int deleteGoods(@Param("shopCartCodeList") List<String> shopCartCodeList, @Param("updater") String updater);
}
