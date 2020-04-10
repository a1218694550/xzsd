package com.xzsd.app.publicInterfince.service;

import com.xzsd.app.publicInterfince.dao.PersonalDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonalService {
    @Resource
    private PersonalDao personalDao;
}
