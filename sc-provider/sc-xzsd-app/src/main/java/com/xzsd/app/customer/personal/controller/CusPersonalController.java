package com.xzsd.app.customer.personal.controller;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.personal.service.CusPersonalService;
import com.xzsd.app.publicInterfince.entity.PasswordInfo;
import com.xzsd.app.publicInterfince.entity.PersonalInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户个人信息管理模块
 * @author zehong
 * @time 2020/4/13
 */
@RestController
@RequestMapping("customer/personal")
public class CusPersonalController {
    private static final Logger logger = LoggerFactory.getLogger(CusPersonalController.class);
    @Resource
    private CusPersonalService personalService;

    /**
     * 修改邀请码
     * @param personalInfo
     * @return
     */
    @PostMapping("updateInvCode")
    public AppResponse updateInvCode(PersonalInfo personalInfo){
        try{
            personalInfo.setUserCode(SecurityUtils.getCurrentUserId());
            AppResponse appResponse = personalService.updateInvCode(personalInfo);
            return appResponse;
        } catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
