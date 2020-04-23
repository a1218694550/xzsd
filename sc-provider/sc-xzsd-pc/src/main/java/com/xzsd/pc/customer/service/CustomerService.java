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
 * @author zehong
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
         * 如果查询人是店长-->获取查询人的门店邀请码
         */
        UserInfo userInfo = userDao.getUser(customerInfo.getOperator());
        if (userInfo.getRole() != 1 && userInfo.getRole() !=2){
            return AppResponse.bizError("您没有权限查询客户列表！");
        }
        String storeInvCode = null;
        if (userInfo.getRole() == 2){
            storeInvCode = customerDao.getInvCode(customerInfo.getOperator());
        }
        if (storeInvCode != null){
            customerInfo.setInvCode(storeInvCode);
        }
        /**
         * 根据角色查询客户列表
         */
        PageHelper.startPage(customerInfo.getPageNum(),customerInfo.getPageSize());
        List<CustomerVo> customerVoList = customerDao.listCustomer(customerInfo);
        PageInfo<CustomerVo> pageData = new PageInfo<>(customerVoList);
        return AppResponse.success("查询客户列表成功!",pageData);
    }
}
