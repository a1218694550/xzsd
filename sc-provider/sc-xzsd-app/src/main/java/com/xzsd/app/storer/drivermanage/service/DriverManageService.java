package com.xzsd.app.storer.drivermanage.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.storer.drivermanage.dao.DriverManageDao;
import com.xzsd.app.storer.drivermanage.entity.DriverVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 司机管理模块
 * @author 泽宏
 */
@Service
public class DriverManageService {
    @Resource
    private DriverManageDao driverManageDao;

    /**
     * 查询司机列表
     * @param userCode
     * @return
     */
    public AppResponse listDriverByPage(String userCode){
        List<DriverVO> driverVOList = driverManageDao.listDriverByPage(userCode);
        return AppResponse.success("查询司机列表成功!",getPageInfo(driverVOList));
    }
}
