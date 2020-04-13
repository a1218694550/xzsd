package com.xzsd.app.storer.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.order.entity.OrderInfo;
import com.xzsd.app.customer.personal.controller.CusPersonalController;
import com.xzsd.app.storer.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("storer/order")
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
}
