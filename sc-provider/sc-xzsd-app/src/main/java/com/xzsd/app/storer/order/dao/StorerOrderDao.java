package com.xzsd.app.storer.order.dao;

import com.xzsd.app.customer.order.entity.Goods;
import com.xzsd.app.customer.order.entity.OrderDetails;
import com.xzsd.app.customer.order.entity.OrderInfo;
import com.xzsd.app.storer.order.entity.StoreVO;

import java.util.List;

/**
 * 店长订单管理模块
 */
public interface StorerOrderDao {
    /**
     * 获取门店详情
     * @param storerCode
     * @return
     */
    StoreVO getStore(String storerCode);
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
    OrderDetails getOrder(String orderCode);

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderStatus(OrderInfo orderInfo);
}
