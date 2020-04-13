package com.xzsd.app.publicInterfince.dao;

import com.xzsd.app.customer.index.entity.UserInfo;
import com.xzsd.app.publicInterfince.entity.PasswordInfo;
import com.xzsd.app.publicInterfince.entity.PersonalInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalDao {
    /**
     * 查询用户角色
     * @param userCode
     * @return
     */
    UserInfo getUser(String userCode);

    /**
     * 查询个人信息
     * @param personalInfo
     * @return
     */
    PersonalInfo getPersonalInfo(PersonalInfo personalInfo);

    /**
     * 修改密码
     * @param passwordInfo
     * @return
     */
    int updatePassword(PasswordInfo passwordInfo);
}
