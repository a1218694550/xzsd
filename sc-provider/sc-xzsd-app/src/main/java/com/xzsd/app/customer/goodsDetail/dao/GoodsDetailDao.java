package com.xzsd.app.customer.goodsDetail.dao;

import com.xzsd.app.customer.goodsDetail.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

@Mapper
public interface GoodsDetailDao {
    /**
     * 查询登录用户绑定的门店信息
     * @param userCode
     * @return
     */
    StoreVO getStoreOfUser(@Param("userCode") String userCode);

    /**
     * 查询商品详情信息
     * @param goodsCode
     * @return
     */
    GoodsVO getGoods(@Param("goodsCode") String goodsCode);
    /**
     * 加入购物车
     * @param opeGoods
     * @return
     */
    int addGoodsToCart(OpeGoods opeGoods);

    /**
     * 修改商品信息
     * @param orderDetailsList
     * @return
     */
    int updateGoods(@Param("orderDetailsList") List<OrderDetails> orderDetailsList);

    /**
     * 新增订单
     * @param addOrderInfo
     * @return
     */
    int addOrder(AddOrderInfo addOrderInfo);

    /**
     * 新增订单详情
     * @param orderDetailsList
     * @return
     */
    int addOrderDetail(@Param("orderDetailsList") List<OrderDetails> orderDetailsList);

    /**
     * 查询评价列表
     * @param goodsEvaluateInfo
     * @return
     */
    List<GoodsEvaluateVO> listGoodsEvaluateByPage(GoodsEvaluateInfo goodsEvaluateInfo);
    List<ImageInfo> listGoodsEvaluateImage(@Param("evaluateCode") String  evaluateCode);
}
