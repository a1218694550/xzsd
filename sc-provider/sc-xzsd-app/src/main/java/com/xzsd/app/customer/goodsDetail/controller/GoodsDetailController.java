package com.xzsd.app.customer.goodsDetail.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.goodsDetail.entity.AddOrderInfo;
import com.xzsd.app.customer.goodsDetail.entity.GoodsEvaluateInfo;
import com.xzsd.app.customer.goodsDetail.entity.OpeGoods;
import com.xzsd.app.customer.goodsDetail.service.GoodsDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品详情模块
 * @author zehong
 * @time 2020/4/8
 */
@RestController
@RequestMapping("customer/goodsDetail")
public class GoodsDetailController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsDetailController.class);
    @Resource
    private GoodsDetailService goodsDetailService;

    /**
     * 查询商品详情
     * @param goodsCode
     * @return
     */
    @RequestMapping("getGoods")
    public AppResponse getGoods(String goodsCode){
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = goodsDetailService.getGoods(goodsCode,userCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 添加商品至购物车
     * @param opeGoods
     * @return
     */
    @PostMapping("addGoodsToCart")
    public AppResponse addGoodsToCart(OpeGoods opeGoods){
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            opeGoods.setUserCode(userCode);
            opeGoods.setCreater(userCode);
            AppResponse appResponse = goodsDetailService.addGoodsToCart(opeGoods);
            return appResponse;
        }catch (Exception e){
            logger.error("添加失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("buyGoods")
    public AppResponse addOrder(AddOrderInfo addOrderInfo){
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            addOrderInfo.setCreater(userCode);
            addOrderInfo.setUserCode(userCode);
            AppResponse appResponse = goodsDetailService.addOrder(addOrderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("购买失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品评价列表
     * @param goodsEvaluateInfo
     * @return
     */
    @RequestMapping("listGoodsEvaluateByPage")
    public AppResponse listGoodsEvaluateByPage(GoodsEvaluateInfo goodsEvaluateInfo){
        try {
            AppResponse appResponse = goodsDetailService.listGoodsEvaluateByPage(goodsEvaluateInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
