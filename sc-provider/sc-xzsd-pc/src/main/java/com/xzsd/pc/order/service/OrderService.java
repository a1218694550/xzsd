package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.Goods;
import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 订单管理模块
 * @author zehong
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     * @throws ParseException
     */
    public AppResponse listOrder(OrderInfo orderInfo) throws ParseException {
        //获取当前登录人的角色
        UserInfo userInfo = orderDao.getUser(orderInfo.getOperator());
        if (userInfo != null && userInfo.getRole()!=0){
            orderInfo.setRole(userInfo.getRole());
        }
        PageHelper.startPage(orderInfo.getPageNum(),orderInfo.getPageSize());
        List<OrderInfo> orderInfoList = orderDao.listOrder(orderInfo);
        PageInfo<OrderInfo> pageData = new PageInfo<>(orderInfoList);

        return AppResponse.success("查询订单列表成功！",pageData);
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    public AppResponse getOrderDetails(String orderCode){
        List<Goods> orderDetailsList = orderDao.getOrderDetails(orderCode);
        return AppResponse.success("查询订单详情成功！",orderDetailsList);
    }

    /**
     * 修改订单状态
     * @param orderCode
     * @param operation
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(String orderCode ,int operation,String updater){
        List<String> orderCodeList = Arrays.asList(orderCode.split(","));
        int result = orderDao.updateOrderState(orderCodeList,operation,updater);
        if (0 == result){
            return AppResponse.bizError("修改订单状态失败!");
        }
        return AppResponse.success("修改订单状态成功!");
    }
}
