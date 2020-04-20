package com.xzsd.pc.goodsclass.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsclass.entity.GoodsClassInfo;
import com.xzsd.pc.goodsclass.service.GoodsClassService;
import com.xzsd.pc.user.controller.UserController;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类管理模块
 * @author zehong
 */
@RestController
@RequestMapping("/manage/goodsclassification")
public class GoodsClassController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsClassController.class);

    @Resource
    private GoodsClassService goodsClassService;

    /**
     * 新增商品分类
     * @param goodsClassInfo
     * @return
     */
    @PostMapping("addGoodsClass")
    public AppResponse addGoodsClass(GoodsClassInfo goodsClassInfo){
        try{
            goodsClassInfo.setCreater(SecurityUtils.getCurrentUserId());
            //新增商品分类
            AppResponse appResponse = goodsClassService.addGoodsClass(goodsClassInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类详情
     * @param goodsClassInfo
     * @return
     */
    @RequestMapping("getGoodsClass")
    public AppResponse getGoodsClass(GoodsClassInfo goodsClassInfo){
        try{
            //查询商品分类详情
            AppResponse appResponse = goodsClassService.getGoodsClass(goodsClassInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品分类
     * @param goodsClassInfo
     * @return
     */
    @PostMapping("updateGoodsClass")
    public AppResponse updateGoodsClass(GoodsClassInfo goodsClassInfo){
        try{
            goodsClassInfo.setUpdater(SecurityUtils.getCurrentUserId());
            //修改商品分类
            AppResponse appResponse = goodsClassService.updateGoodsClass(goodsClassInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类列表
     * @return
     */
    @RequestMapping("listGoodsClass")
    public AppResponse listGoodsClass(){
        try{
            //查询商品分类列表
            AppResponse appResponse = goodsClassService.listGoodsClass();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     * @return
     */
    @PostMapping("deleteGoodsClass")
    public AppResponse deleteGoodsClass(GoodsClassInfo goodsClassInfo){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            goodsClassInfo.setUpdater(updater);
            //删除商品分类
            AppResponse appResponse = goodsClassService.deleteGoodsClass(goodsClassInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
