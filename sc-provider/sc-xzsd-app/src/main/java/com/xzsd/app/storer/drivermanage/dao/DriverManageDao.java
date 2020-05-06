package com.xzsd.app.storer.drivermanage.dao;

import com.xzsd.app.storer.drivermanage.entity.DriverVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 司机管理模块
 * @author 泽宏
 */
public interface DriverManageDao {
    /**
     * 查询司机列表
     * @param userCode
     * @return
     */
    List<DriverVO> listDriverByPage(@Param("userCode") String userCode);
}
