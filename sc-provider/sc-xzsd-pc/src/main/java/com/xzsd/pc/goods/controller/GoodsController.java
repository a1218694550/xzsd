package com.xzsd.pc.goods.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品管理模块
 * @author zehong
 * @time 2020/4/16
 */
@RestController
@RequestMapping("/manage/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 查询商品一级分类列表
     * @return
     */
    @RequestMapping("listClassOne")
    public AppResponse listGoodsClassOne(){
        try{
            //查询商品一级分类列表
            AppResponse appResponse = goodsService.listGoodsClassOne();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品二级分类列表
     * @param classOneCode
     * @return
     */
    @RequestMapping("listClassSecond")
    public AppResponse listGoodsClassSecond(String classOneCode){
        try{
            //查询商品一级分类下所属二级分类列表
            AppResponse appResponse = goodsService.listGoodsClassSecond(classOneCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goods){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            goods.setCreater(userId);
            //查询商品一级分类下所属二级分类列表
            AppResponse appResponse = goodsService.addGoods(goods);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     * @param goodsCode
     * @return
     */
    @RequestMapping("getGoods")
    public AppResponse getGoods(String goodsCode){
        try{
            //查询商品详情
            AppResponse appResponse = goodsService.getGoods(goodsCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品信息
     * @param goods
     * @return
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goods){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            goods.setUpdater(userId);
            AppResponse appResponse = goodsService.updateGoods(goods);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品列表
     * @param goods
     * @return
     */
    @RequestMapping("listGoods")
    public AppResponse listGoods(GoodsInfo goods){
        try {

            AppResponse appResponse = goodsService.listGoods(goods);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     * @param goodsCode
     * @return
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = goodsService.deleteGoods(goodsCode,userId);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     * @param goodsCode
     * @param goodsStatus
     * @return
     */
    @PostMapping("updateGoodsStatus")
    public AppResponse updateGoodsStatus(String goodsCode , String goodsStatus){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = goodsService.updateGoodsStatus(goodsCode,goodsStatus,userId);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
