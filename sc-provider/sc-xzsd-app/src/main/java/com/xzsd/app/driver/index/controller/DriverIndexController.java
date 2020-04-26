package com.xzsd.app.driver.index.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.index.entity.StoreInfo;
import com.xzsd.app.driver.index.service.DriverIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("driver/index")
public class DriverIndexController {
    private static final Logger logger = LoggerFactory.getLogger(DriverIndexController.class);
    @Resource
    private DriverIndexService driverIndexService;

    /**
     * 查询司机负责门店列表
     * @param storeInfo
     * @return
     */
    @RequestMapping("listStoreByPage")
    public AppResponse listStoreByPage(StoreInfo storeInfo){
        try {
            storeInfo.setDriverCode(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = driverIndexService.listStoreByPage(storeInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
