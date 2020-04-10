package com.xzsd.pc.elasticsearch.service;

/*
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.sprintboot.elasticsearch.dao.UserRepository;
import com.neusoft.sprintboot.elasticsearch.entity.User;
import com.neusoft.sprintboot.util.AppResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ESService {
    @Resource
    private UserRepository userRepository;

    */
/**
     * 新增用户
     * @param user
     * @return
     *//*

    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveUser(User user){
        return AppResponse.success("新增成功",userRepository.save(user));
    }
    public AppResponse getUser(String userCode){
        return AppResponse.success("查询成功",userRepository.findById(userCode));
    }
    public AppResponse listUser(String userCode){
        List<String> listCode = Arrays.asList(userCode.split(","));
        Iterable iterable = userRepository.findAllById(listCode);
        List<User> userList = new ArrayList<>();
        iterable.forEach(e->userList.add((User) e));
        return AppResponse.success("查询成功",userList);
    }
    public AppResponse findAllUser(int pageNum , int pageSize){
        PageHelper.startPage(pageNum,pageSize);

        Iterable iterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        iterable.forEach(e->userList.add((User)e));

        PageInfo<User> pageData = new PageInfo(userList);
        return AppResponse.success("查询成功",pageData);
    }
}
*/
