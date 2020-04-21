package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.Goods;
import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单管理模块
 * @author asus
 */
public interface OrderDao {
    /**
     * 查询用户角色
     * @param userCode
     * @return
     */
    UserInfo getUser(@Param("userCode") String userCode);
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
    List<Goods> getOrderDetails(@Param("orderCode") String orderCode);

    /**
     * 修改订单状态
     * @param orderCodeList 订单编码 多个编码用’,’分隔
     * @param orderStatus
     * @param updater
     * @return
     */
    int updateOrderState(@Param("orderCodeList") List<String> orderCodeList,@Param("orderStatus") int orderStatus,@Param("updater") String updater);
}
