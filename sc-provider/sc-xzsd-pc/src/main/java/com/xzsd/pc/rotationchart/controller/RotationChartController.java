package com.xzsd.pc.rotationchart.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.rotationchart.entity.RCGoodsVO;
import com.xzsd.pc.rotationchart.entity.RotationChartInfo;
import com.xzsd.pc.rotationchart.service.RotationChartService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 轮播图管理模块
 * @author asus
 */
@RestController
@RequestMapping("/manage/rotationChart")
public class RotationChartController {
    private static final Logger logger = LoggerFactory.getLogger(RotationChartController.class);

    @Resource
    private RotationChartService rotationChartService;

    /**
     * 新增轮播图信息
     * @param rotationChartInfo
     * @return
     */
    @PostMapping("addRotationChart")
    public AppResponse addRotationChart(RotationChartInfo rotationChartInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            rotationChartInfo.setCreater(userId);
            AppResponse appResponse = rotationChartService.addRotationChart(rotationChartInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品列表
     * @param rcGoodsVO
     * @return
     */
    @RequestMapping("listGoods")
    public AppResponse listGoods(RCGoodsVO rcGoodsVO){
        try{
            AppResponse appResponse = rotationChartService.listGoods(rcGoodsVO);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图详情
     * @param rotationChartCode
     * @return
     */
    @RequestMapping("getRotationChart")
    public AppResponse getRotationChart(String rotationChartCode){
        try{
            AppResponse appResponse = rotationChartService.getRotationChart(rotationChartCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图列表
     * @param rotationChartInfo
     * @return
     */
    @RequestMapping("listRotationChart")
    public AppResponse listRotationChart(RotationChartInfo rotationChartInfo){
        try{
            AppResponse appResponse = rotationChartService.listRotationChart(rotationChartInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * @param rotationChartCode
     * @return
     */
    @PostMapping("deleteRotationChart")
    public AppResponse deleteRotationChart(String rotationChartCode){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = rotationChartService.deleteRotationChart(rotationChartCode,updater);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改轮播图状态
     * @param rotationChartCode
     * @param status
     * @return
     */
    @PostMapping("updateRotationChartState")
    public AppResponse updateRotationChartState(String rotationChartCode , String status){
        try{
            String updater = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = rotationChartService.updateRotationChartState(rotationChartCode,status,updater);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
