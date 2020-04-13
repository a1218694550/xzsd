package com.xzsd.app.customer.personal.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.personal.dao.CusPersonalDao;
import com.xzsd.app.publicInterfince.entity.PersonalInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CusPersonalService {
    @Resource
    private CusPersonalDao cusPersonalDao;

    /**
     * 修改邀请码
     * @param personalInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateInvCode(PersonalInfo personalInfo){
        int countInv = cusPersonalDao.countInvCode(personalInfo.getInvCode());
        if (0 == countInv){
            return AppResponse.bizError("修改邀请码失败，请检查邀请码是否正确！");
        }
        int resultUpdate = cusPersonalDao.updateInvCode(personalInfo);
        if (0 == resultUpdate){
            return AppResponse.bizError("修改邀请码失败，请检查邀请码格式是否正确！");
        }
        return AppResponse.success("修改邀请码成功！");
    }
}
