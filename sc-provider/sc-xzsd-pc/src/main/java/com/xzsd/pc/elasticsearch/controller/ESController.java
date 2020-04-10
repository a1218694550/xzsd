package com.xzsd.pc.elasticsearch.controller;


/*
import com.neusoft.sprintboot.elasticsearch.entity.User;
import com.neusoft.sprintboot.elasticsearch.service.ESService;
import com.neusoft.sprintboot.order.controller.OrderController;
import com.neusoft.sprintboot.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("elasticSearch")
public class ESController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private ESService esService;

    @RequestMapping("saveUser")
    public AppResponse saveUser(User user){
        try{

            return AppResponse.success("新增成功",esService.saveUser(user));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @PostMapping("getUser")
    public AppResponse getUser(String userCode){
        try{
            return AppResponse.success("查询成功",esService.getUser(userCode));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @PostMapping("listUser")
    public AppResponse listUser(String userCode){
        try{
            return AppResponse.success("查询成功",esService.listUser(userCode));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @PostMapping("findAllUser")
    public AppResponse findAllUser(int pageNum , int pageSize){
        try{
            return AppResponse.success("查询成功",esService.findAllUser(pageNum,pageSize));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
*/
