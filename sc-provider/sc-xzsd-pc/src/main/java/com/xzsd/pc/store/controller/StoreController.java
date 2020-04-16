package com.xzsd.pc.store.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 门店管理模块
 * @author asus
 */
@RestController
@RequestMapping("/manage/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    @RequestMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreater(userId);
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     */
    @RequestMapping("getStore")
    public AppResponse getStore(String storeCode){
        try{
            AppResponse appResponse = storeService.getStore(storeCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo){
        try{
            storeInfo.setUpdater(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = storeService.updateStore(storeInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询省份列表
     * @return
     */
    @RequestMapping("listProvince")
    public AppResponse listProvince(){
        try{
            AppResponse appResponse = storeService.listProvince();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询城市列表
     * @param provinceCode
     * @return
     */
    @RequestMapping("listCity")
    public AppResponse listCity(String provinceCode){
        try{
            AppResponse appResponse = storeService.listCity(provinceCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询区列表
     * @param cityCode
     * @return
     */
    @RequestMapping("listArea")
    public AppResponse listArea(String cityCode){
        try{
            AppResponse appResponse = storeService.listArea(cityCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店列表
     * @param storeInfo
     * @return
     */
    @RequestMapping("listStore")
    public AppResponse listStore(StoreInfo storeInfo){
        try{
            //获取当前登录人的信息
            String userCode = SecurityUtils.getCurrentUserId();
            storeInfo.setOperator(userCode);
            AppResponse appResponse = storeService.listStore(storeInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店信息
     * @param storeCode
     * @return
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeCode){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = storeService.deleteStore(storeCode,updater);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
