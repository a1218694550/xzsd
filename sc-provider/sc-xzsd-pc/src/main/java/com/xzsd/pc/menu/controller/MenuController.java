package com.xzsd.pc.menu.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotgoods.controller.HotGoodsController;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 菜单管理模块
 * @author 泽宏
 */
@RestController
@RequestMapping("/manage/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            menuInfo.setCreater(userCode);
            AppResponse appResponse = menuService.addMenu(menuInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     */
    @RequestMapping("getMenu")
    public AppResponse getMenu(String menuCode){
        try{
            AppResponse appResponse = menuService.getMenu(menuCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            menuInfo.setUpdater(userCode);
            AppResponse appResponse = menuService.updateMenu(menuInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单列表
     * @return
     */
    @RequestMapping("listMenu")
    public AppResponse listMenu(){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = menuService.listMenu(userCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param menuCode
     * @return
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = menuService.deleteMenu(menuCode,updater);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
