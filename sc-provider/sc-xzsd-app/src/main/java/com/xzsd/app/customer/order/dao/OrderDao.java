package com.xzsd.app.customer.order.dao;

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
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderStatus(OrderInfo orderInfo);

    int addGoodsEvaluate( OrderEvaluate orderEvaluate);
    int addEvaluateImg(@Param("evaluateImgList") List<EvaluateImg> evaluateImgList);
}
