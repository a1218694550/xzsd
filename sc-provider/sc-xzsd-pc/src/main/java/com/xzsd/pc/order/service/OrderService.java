package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.Goods;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.SystemValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<OrderVO> orderInfoList = orderDao.listOrder(orderInfo);
        PageInfo<OrderVO> pageData = new PageInfo<>(orderInfoList);

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
        List<OrderVO> orderInfoList = orderDao.listOrderMes(orderCodeList);
        //构成可修改状态的订单列表
        List<String> newOrderCodeList = new ArrayList<>();
        for (OrderVO orderVO : orderInfoList) {
            int status = Integer.parseInt(orderVO.getOrderStatus());
            //去除已完成的订单
            if (status == SystemValue.ORDER_STATUS_SUCCESS_VALUE
                    || status == SystemValue.ORDER_STATUS_EVALUETED_VALUE) {
                continue;
            }
            newOrderCodeList.add(orderVO.getOrderCode());
        }
        if (newOrderCodeList.size() == 0){
            return AppResponse.bizError("选中的订单已完成，无法修改状态！");
        }
        String mes = "";
        if (orderCodeList.size() != newOrderCodeList.size()){
            mes = "部分订单已完成无法修改状态！";
        }
        int result = orderDao.updateOrderState(newOrderCodeList,operation,updater);
        if (0 == result){
            return AppResponse.bizError("修改订单状态失败!" + mes);
        }
        //如果操作为取消订单，则恢复商品库存
        if (SystemValue.ORDER_STATUS_CANCEL_VALUE == operation){
            List<Goods> orderDetails = orderDao.listOrderDetails(newOrderCodeList);
            int updateStockCount = orderDao.updateGoodsStock(orderDetails);
            if (0 == updateStockCount){
                return AppResponse.bizError("修改订单状态失败，库存修改失败!");
            }
        }
        return AppResponse.success("修改订单状态成功!" + mes);
    }
}
