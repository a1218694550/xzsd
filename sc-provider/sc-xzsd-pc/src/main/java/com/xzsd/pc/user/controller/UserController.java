package com.xzsd.pc.user.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理
 * @author zehong
 * @time 2020-03-24
 */
@RestController
@RequestMapping("/manage/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("login")
    public AppResponse login(UserInfo userInfo){
        try{
            //登录
            AppResponse appResponse = userService.login(userInfo) ;
            return appResponse;
        }catch (Exception e){
            logger.error("登录失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    @RequestMapping("addUser")
    public AppResponse addUser(UserInfo userInfo){
        try{
            //获取当前用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreater(userId);
            AppResponse appResponse = userService.addUser(userInfo) ;
            return appResponse;
        }catch (Exception e){
            logger.error("查询用户失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    @RequestMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo){
        try{
            //获取当前用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setUpdater(userId);
            AppResponse appResponse = userService.updateUser(userInfo) ;
            return appResponse;
        }catch (Exception e){
            logger.error("修改用户失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户详情
     * @param userCode
     * @return
     */
    @RequestMapping("getUser")
    public AppResponse getUser(String userCode){
        try{
            AppResponse appResponse = userService.getUser(userCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询用户失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除用户
     * @param userInfo
     * @return
     */
    @RequestMapping("deleteUser")
    public AppResponse deleteUser(UserInfo userInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = userService.deleteUser(userInfo , userId);
            return appResponse;
        }catch (Exception e){
            logger.error("删除用户失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户列表
     * @param userInfo
     * @return
     */
    @RequestMapping("listUser")
    public AppResponse listUser(UserInfo userInfo){
        try{
            AppResponse appResponse = userService.listUser(userInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询用户列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询登录用户信息
     * @return
     */
    @RequestMapping("userMessage")
    public AppResponse UserMessage(){
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = userService.UserMessage(userCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询用户失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
