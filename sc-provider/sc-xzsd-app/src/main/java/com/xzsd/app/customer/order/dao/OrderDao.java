package com.xzsd.app.customer.order.dao;

import com.xzsd.app.customer.goodsDetail.entity.GoodsInfo;
import com.xzsd.app.customer.order.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    List<OrderDetails> listOrderByPage(OrderInfo orderInfo);
    List<Goods> orderGoods(OrderInfo orderInfo);
    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    OrderDetails getOrder(@Param("orderCode") String orderCode);

    /**
     * 查询订单状态
     * @param orderCode
     * @return
     */
    OrderVO getOrderStatus(@Param("orderCode") String orderCode);

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderStatus(OrderInfo orderInfo);

    /**
     * 新增商品评价
     * @param orderEvaluate
     * @return
     */
    int addGoodsEvaluate( OrderEvaluate orderEvaluate);
    int addEvaluateImg(@Param("evaluateImgList") List<EvaluateImg> evaluateImgList);

    /**
     * 修改商品评价星级
     * @param evaluateInfoList
     * @return
     */
    int updateGoodsStar(@Param("evaluateInfoList") List<EvaluateInfo> evaluateInfoList);

    /**
     * 修改商品库存
     * @param goodsList
     * @return
     */
    int updateGoodsStock(@Param("goodsList")List<Goods> goodsList);

    /**
     * 修改商品销量
     * @param goodsList
     * @return
     */
    int updateGoodsSales(@Param("goodsList")List<Goods> goodsList);
}
