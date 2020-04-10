package com.xzsd.app.customer.index.dao;


import com.xzsd.app.customer.index.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexDao {
    /**
     * 校验验证码
     * @param invCode
     * @return
     */
    int findInvCode(String invCode);

    /**
     * 统计用户数量
     * @param customerInfo
     * @return
     */
    int countUserAcct(CustomerInfo customerInfo);

    /**
     * 新增客户
     * @param customerInfo
     * @return
     */
    int addUser(CustomerInfo customerInfo);
    int addCustomer(CustomerInfo customerInfo);

    /**
     * 查询轮播图列表
     * @return
     */
    List<RotationChartVO> listRotationChart();

    /**
     * 查询展示数量
     * @return
     */
    String getDisPlayCount();
    /**
     * 查询热门商品列表
     * @return
     */
    List<HotGoodsVO> listHotGoods(int disPlayCount);
}
