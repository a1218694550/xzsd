package com.xzsd.app.publicInterfince.controller;

import com.xzsd.app.publicInterfince.service.PersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("public")
public class PersonalController {
    private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);
    @Resource
    private PersonalService personalService;


}
