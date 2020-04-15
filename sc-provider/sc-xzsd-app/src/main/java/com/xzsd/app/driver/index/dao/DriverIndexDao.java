package com.xzsd.app.driver.index.dao;

import com.xzsd.app.driver.index.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverIndexDao {
    /**
     * 查询司机负责门店列表
     * @param storeInfo
     * @return
     */
    List<StoreInfo> listStoreByPage(StoreInfo storeInfo);
}
