package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zehong
 * @time 2020/3/31
 */
@Mapper
public interface CustomerDao {
    /**
     * 查询客户列表
     * @param customerInfo
     * @return
     */
    List<CustomerVo> listCustomer(CustomerInfo customerInfo);
}
