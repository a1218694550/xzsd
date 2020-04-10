package com.xzsd.pc.activermqcustomer.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author asus
 */
@Mapper
public interface ConsumerDao {
    int addMessage(String messageCode, String goodsInfo);
}
