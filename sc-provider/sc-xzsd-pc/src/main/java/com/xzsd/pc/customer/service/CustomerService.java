package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户管理模块
 */
@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;
    @Resource
    private UserDao userDao;
    /**
     * 查询客户列表
     * @param customerInfo
     * @return
     */
    public AppResponse listCustomer(CustomerInfo customerInfo){
        /**
         * 获取查询人的角色
         */
        UserInfo userInfo = userDao.getUser(customerInfo.getOperator());
        customerInfo.setRole(userInfo.getRole());
        /**
         * 根据角色查询客户列表
         */
        PageHelper.startPage(customerInfo.getPageNum(),customerInfo.getPageSize());
        List<CustomerVo> customerVoList = customerDao.listCustomer(customerInfo);
        PageInfo<CustomerVo> pageData = new PageInfo<>(customerVoList);
        return AppResponse.success("查询客户列表成功!",pageData);
    }
}
