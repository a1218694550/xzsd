package com.xzsd.app.publicInterfince.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.index.entity.UserInfo;
import com.xzsd.app.publicInterfince.dao.PersonalDao;
import com.xzsd.app.publicInterfince.entity.PasswordInfo;
import com.xzsd.app.publicInterfince.entity.PersonalInfo;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PersonalService {
    @Resource
    private PersonalDao personalDao;

    /**
     * 查询个人信息
     * @param personalInfo
     * @return
     */
    public AppResponse getPersonalInfo(PersonalInfo personalInfo){
        //获取角色
        UserInfo userInfo = personalDao.getUser(personalInfo.getUserCode());
        personalInfo.setRole(userInfo.getRole());
        //根据角色查询
        PersonalInfo personalInfoRes = personalDao.getPersonalInfo(personalInfo);
        return AppResponse.success("查询个人信息成功！",personalInfoRes);
    }

    /**
     * 修改密码
     * @param passwordInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePassword(PasswordInfo passwordInfo){
        //校验原密码
        if(null != passwordInfo.getPassword() && !"".equals(passwordInfo.getPassword())) {
            //获取输入的原密码
            String oldPwd = passwordInfo.getPassword();
            // 获取用户信息
            UserInfo userDetail = personalDao.getUser(passwordInfo.getUserCode());
            if (null == userDetail) {
                return AppResponse.bizError("用户不存在或已被删除！");
            } else {
                if (!PasswordUtils.PasswordMacth(oldPwd,userDetail.getUserPwd())) {
                    System.out.println("  输入的原密码："+ oldPwd);
                    System.out.println("数据库加密过的原密码："+ userDetail.getUserPwd());
                    return AppResponse.bizError("原密码不匹配，请重新输入！");
                }
            }
        }else {
            return AppResponse.bizError("原密码格式错误，请重新输入！");
        }
        //修改密码 加密新密码
        passwordInfo.setNewPassword(PasswordUtils.generatePassword(passwordInfo.getNewPassword()));
        int resultUpdate = personalDao.updatePassword(passwordInfo);
        if (0 == resultUpdate){
            return AppResponse.bizError("修改密码失败！，原密码不匹配，请检查原密码是否正确！");
        }
        return AppResponse.success("修改密码成功！");
    }

}
