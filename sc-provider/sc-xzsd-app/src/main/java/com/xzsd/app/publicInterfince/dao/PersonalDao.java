package com.xzsd.app.publicInterfince.dao;

import com.xzsd.app.publicInterfince.entity.PersonalInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalDao {
    PersonalInfo getPersonalInfo(PersonalInfo personalInfo);
}
