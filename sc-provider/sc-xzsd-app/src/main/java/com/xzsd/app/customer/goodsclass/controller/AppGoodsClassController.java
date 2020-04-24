package com.xzsd.app.customer.goodsclass.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.goodsclass.service.AppGoodsClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author asus
 */
@RestController
@RequestMapping("customer/goodsClass")
public class AppGoodsClassController {
    private static final Logger logger = LoggerFactory.getLogger(AppGoodsClassController.class);
    @Resource
    private AppGoodsClassService goodsClassService;

    /**
     * 查询商品一级分类列表
     * @return
     */
    @RequestMapping("listGoodsClassOne")
    public AppResponse listGoodsClassOne(){
        try {
            AppResponse appResponse = goodsClassService.listGoodsClassOne();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品二级分类以及分类下的商品列表
     * @param classOneCode
     * @return
     */
    @RequestMapping("listGoodsSecondAndGoods")
    public AppResponse listGoodsSecondAndGoods(String classOneCode){
        try {
            AppResponse appResponse = goodsClassService.listGoodsSecondAndGoods(classOneCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
