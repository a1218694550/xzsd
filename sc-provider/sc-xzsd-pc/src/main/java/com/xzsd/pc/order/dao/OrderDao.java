package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.entity.UserInfo;

import java.util.List;

/**
 * @author asus
 */
public interface OrderDao {
    UserInfo getUser(String userCode);
    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    List<OrderInfo> listOrder(OrderInfo orderInfo);

    /**
     * 获取订单详情
     * @param orderCode
     * @return
     */
    OrderDetails getOrderDetails(String orderCode);

    /**
     * 修改订单状态
     * @param orderCodeList 订单编码 多个编码用’,’分隔
     * @param orderStatus
     * @param updater
     * @return
     */
    int updateOrderState(List<String> orderCodeList, int orderStatus, String updater);
}
