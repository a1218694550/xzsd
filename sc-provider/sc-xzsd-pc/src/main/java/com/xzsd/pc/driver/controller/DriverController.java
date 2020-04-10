package com.xzsd.pc.driver.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;

    /**
     * 新增司机
     * @param driverInfo
     * @return
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try{
            String creater = SecurityUtils.getCurrentUserId();
            driverInfo.setCreater(creater);
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机详情
     * @param driverCode
     * @return
     */
    @RequestMapping("getDriver")
    public AppResponse getDriver(String driverCode){
        try{
            AppResponse appResponse = driverService.getDriver(driverCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            driverInfo.setUpdater(updater);
            AppResponse appResponse = driverService.updateDriver(driverInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机列表
     * @param driverInfo
     * @return
     */
    @RequestMapping("listDriver")
    public AppResponse listDriver(DriverInfo driverInfo){
        try{
            String operator = SecurityUtils.getCurrentUserId();
            driverInfo.setOperator(operator);
            AppResponse appResponse = driverService.listDriver(driverInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机信息
     * @param driverCode
     * @return
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverCode){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = driverService.deleteDriver(driverCode,updater);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
