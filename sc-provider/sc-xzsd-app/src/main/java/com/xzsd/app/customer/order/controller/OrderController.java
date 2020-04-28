package com.xzsd.app.customer.order.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.order.entity.OrderEvaluate;
import com.xzsd.app.customer.order.entity.OrderInfo;

import com.xzsd.app.customer.order.service.OrderService;
import com.xzsd.app.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * 订单管理模块：顾客端
 * @author zehong
 * @time 2020/4/28
 */
@RestController
@RequestMapping("customer/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    @RequestMapping("listOrderByPage")
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        try{
            orderInfo.setCustomerCode(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = orderService.listOrderByPage(orderInfo);
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
    @RequestMapping("getOrder")
    public AppResponse getOrder(String orderCode){
        try{
            AppResponse appResponse = orderService.getOrder(orderCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @PostMapping("updateOrderStatus")
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        try{
            orderInfo.setUpdater(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = orderService.updateOrderStatus(orderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 商品评价
     * @param jsonStr
     * @return
     */
    @PostMapping("goodsEvaluate")
    public AppResponse goodsEvaluate(String jsonStr){
        try{
            //@RequestBody(required=false) OrderEvaluate orderEvaluate
            OrderEvaluate orderEvaluate = JsonUtils.fromJson(jsonStr,OrderEvaluate.class);
            orderEvaluate.setUpdater(SecurityUtils.getCurrentUserId());
            orderEvaluate.setCreater(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = orderService.goodsEvaluate(orderEvaluate);
            return appResponse;
        }catch (Exception e){
            logger.error("评价失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
