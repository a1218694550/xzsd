package com.xzsd.pc.customer.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;

    @RequestMapping("listCustomer")
    public AppResponse listCustomer(CustomerInfo customerInfo){
        try {
            String operator = SecurityUtils.getCurrentUserId();
            customerInfo.setOperator(operator);
            AppResponse appResponse = customerService.listCustomer(customerInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
