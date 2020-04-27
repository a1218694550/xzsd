package com.xzsd.app.customer.personal.dao;

import com.xzsd.app.customer.index.entity.UserInfo;
import com.xzsd.app.publicInterfince.entity.PersonalInfo;
import org.apache.ibatis.annotations.Param;

public interface CusPersonalDao {
    int countInvCode(@Param("invCode") String invCode);
    int updateInvCode(PersonalInfo personalInfo);
}
