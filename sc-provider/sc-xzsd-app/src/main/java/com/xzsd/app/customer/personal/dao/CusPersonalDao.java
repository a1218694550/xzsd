package com.xzsd.app.customer.personal.dao;

import com.xzsd.app.customer.index.entity.UserInfo;
import com.xzsd.app.publicInterfince.entity.PersonalInfo;

public interface CusPersonalDao {
    int countInvCode(String invCode);
    int updateInvCode(PersonalInfo personalInfo);
}
