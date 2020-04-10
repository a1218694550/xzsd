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
        UserInfo userInfo = userDao.getUser(customerInfo.getOperator());
        System.out.println(customerInfo.getOperator());
        customerInfo.setRole(userInfo.getRole());
        System.out.println(customerInfo.getRole());

        PageHelper.startPage(customerInfo.getPageNum(),customerInfo.getPageSize());
        List<CustomerVo> customerVoList = customerDao.listCustomer(customerInfo);
        PageInfo<CustomerVo> pageData = new PageInfo<>(customerVoList);

        return AppResponse.success("查询客户列表成功!",pageData);
    }
}
