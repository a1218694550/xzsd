package com.xzsd.app.driver.index.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.index.dao.DriverIndexDao;
import com.xzsd.app.driver.index.entity.StoreInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class DriverIndexService {
    @Resource
    private DriverIndexDao driverIndexDao;

    /**
     * 查询司机负责门店列表
     * @param storeInfo
     * @return
     */
    public AppResponse listStoreByPage(StoreInfo storeInfo){
        List<StoreInfo> storeInfoList = driverIndexDao.listStoreByPage(storeInfo);
        return AppResponse.success("查询门店列表成功！",getPageInfo(storeInfoList));
    }
}
