package com.xzsd.app.storer.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.order.entity.OrderInfo;
import com.xzsd.app.customer.personal.controller.CusPersonalController;
import com.xzsd.app.storer.order.service.StorerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 店长订单管理模块
 * @author asus
 */
@RestController
@RequestMapping("storer/order")
public class StorerOrderController {
    private static final Logger logger = LoggerFactory.getLogger(StorerOrderController.class);
    @Resource
    private StorerOrderService storerOrderService;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    @RequestMapping("storeListOrderByPage")
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        try{
            orderInfo.setStorerCode(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = storerOrderService.listOrderByPage(orderInfo);
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
    @RequestMapping("storeGetOrder")
    public AppResponse getOrder(String orderCode){
        try{
            AppResponse appResponse = storerOrderService.getOrder(orderCode);
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
    @PostMapping("storeUpdateOrderStatus")
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        try{
            orderInfo.setUpdater(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = storerOrderService.updateOrderStatus(orderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
