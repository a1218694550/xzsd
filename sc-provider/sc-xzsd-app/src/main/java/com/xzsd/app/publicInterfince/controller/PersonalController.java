package com.xzsd.app.publicInterfince.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.publicInterfince.entity.PasswordInfo;
import com.xzsd.app.publicInterfince.entity.PersonalInfo;
import com.xzsd.app.publicInterfince.service.PersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("public")
public class PersonalController {
    private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);
    @Resource
    private PersonalService personalService;

    /**
     * 查询个人信息
     * @return
     */
    @RequestMapping("getPersonalInfo")
    public AppResponse getPersonalInfo(){
        try{
            PersonalInfo personalInfo = new PersonalInfo();
            personalInfo.setUserCode(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = personalService.getPersonalInfo(personalInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改密码
     * @param passwordInfo
     * @return
     */
    @PostMapping("updatePassword")
    public AppResponse updatePassword(PasswordInfo passwordInfo){
        try{
            passwordInfo.setUserCode(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = personalService.updatePassword(passwordInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
