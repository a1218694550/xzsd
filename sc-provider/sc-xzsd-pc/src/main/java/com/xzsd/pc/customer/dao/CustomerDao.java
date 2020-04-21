package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVo;
import com.xzsd.pc.elasticsearch.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户管理模块
 * @author zehong
 * @time 2020/3/31
 */
@Mapper
public interface CustomerDao {
    /**
     * 查询门店邀请码
     * @param operator
     * @return
     */
    String getInvCode(@Param("operator") String operator);
    /**
     * 查询客户列表
     * @param customerInfo
     * @return
     */
    List<CustomerVo> listCustomer(CustomerInfo customerInfo);
}
