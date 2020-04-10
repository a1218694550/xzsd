package com.xzsd.app.customer.index.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.index.entity.CustomerInfo;
import com.xzsd.app.customer.index.service.IndexService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

import javax.annotation.Resource;

@RestController
@RequestMapping("customer/index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private IndexService indexService;

    /**
     * 注册账号
     * @param customerInfo
     * @return
     */
    @PostMapping("addCustomer")
    public AppResponse addCustomer(CustomerInfo customerInfo){
        try{
            String creater = SecurityUtils.getCurrentUserId();
            customerInfo.setCreater(creater);
            AppResponse appResponse = indexService.addCustomer(customerInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("注册失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图列表
     * @return
     */
    @RequestMapping("listRotationChart")
    public AppResponse listRotationChart(){
        try{
            AppResponse appResponse = indexService.listRotationChart();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表
     * @return
     */
    @RequestMapping("listHotGoods")
    public AppResponse listHotGoods(){
        try{
            AppResponse appResponse = indexService.listHotGoods();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
