package com.xzsd.pc.hotgoods.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage/hotGoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);
    @Resource
    private HotGoodsService hotGoodsService;
    @PostMapping("setDisplayCount")
    public AppResponse setDisplayCount(String displayCount,int version) {
        try {
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = hotGoodsService.setDisplayCount(updater,displayCount,version);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    @PostMapping("addHotGoods")
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            String creater = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreater(creater);
            AppResponse appResponse = hotGoodsService.addHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品详情
     * @param hotGoodsCode
     * @return
     */
    @RequestMapping("getHotGoods")
    public AppResponse getHotGoods(String hotGoodsCode){
        try {
            AppResponse appResponse = hotGoodsService.getHotGoods(hotGoodsCode);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品信息
     * @param hotGoodsInfo
     * @return
     */
    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            String updater = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setUpdater(updater);
            AppResponse appResponse = hotGoodsService.updateHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表
     * @param hotGoodsInfo
     * @return
     */
    @RequestMapping("listHotGoods")
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            AppResponse appResponse = hotGoodsService.listHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门商品 多个编号用,分开
     * @param hotGoodsCode
     * @return
     */
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsCode){
        try {
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = hotGoodsService.deleteHotGoods(hotGoodsCode,updater);
            return appResponse;
        } catch (Exception e) {
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
