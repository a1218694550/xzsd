package com.xzsd.app.storer.drivermanage.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.storer.drivermanage.service.DriverManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("storer/driver")
public class DriverManageController {
    private static final Logger logger = LoggerFactory.getLogger(DriverManageController.class);
    @Resource
    private DriverManageService driverManageService;

    /**
     * 查询司机列表
     * @return
     */
    @RequestMapping("storeListDriverByPage")
    public AppResponse listDriverByPage(){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = driverManageService.listDriverByPage(userCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
