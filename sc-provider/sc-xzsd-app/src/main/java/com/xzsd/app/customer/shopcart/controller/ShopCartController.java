package com.xzsd.app.customer.shopcart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.shopcart.entity.ShopCartGoodsInfo;
import com.xzsd.app.customer.shopcart.service.ShopCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 购物车模块
 */
@RestController
@RequestMapping("customer/shopcart")
public class ShopCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShopCartController.class);
    @Resource
    private ShopCartService shopCartService;

    /**
     * 查询购物车内商品列表成功
     * @return
     */
    @RequestMapping("listGoodsByPage")
    public AppResponse listGoodsByPage(){
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = shopCartService.listGoodsByPage(userCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品数量
     * @param shopCartGoodsInfo
     * @return
     */
    @PostMapping("updateGoodsCount")
    public AppResponse updateGoodsCount(ShopCartGoodsInfo shopCartGoodsInfo){
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            shopCartGoodsInfo.setUserCode(userCode);
            AppResponse appResponse = shopCartService.updateGoodsCount(shopCartGoodsInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 将商品移出购物车
     * @param shopCartCode
     * @return
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String shopCartCode){
        try {
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = shopCartService.deleteGoods(shopCartCode,updater);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
