package com.xzsd.pc.order.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * 订单管理模块
 * @author zehong
 */
@RestController
@RequestMapping("/manage/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     * @throws ParseException
     */
    @RequestMapping("listOrder")
    public AppResponse listOrder(OrderInfo orderInfo) throws ParseException {
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            orderInfo.setOperator(userCode);
            //查询
            AppResponse appResponse = orderService.listOrder(orderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    @RequestMapping(value = "getOrderDetails",method = RequestMethod.GET)
    public AppResponse getOrderDetails(String orderCode){
        try{
            //查询
            AppResponse appResponse = orderService.getOrderDetails(orderCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderCode
     * @param operation
     * @return
     */
    @RequestMapping("updateOrderState")
    public AppResponse updateOrderState(String orderCode ,int operation){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            //修改订单状态
            AppResponse appResponse = orderService.updateOrderState(orderCode,operation,updater);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
