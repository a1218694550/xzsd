package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 司机管理模块
 * @author zehong
 */
@Mapper
public interface DriverDao {
    /**
     * 查询用户角色
     * @param userCode
     * @return
     */
    UserInfo getUser(String userCode);
    /**
     * 统计用户账号数量 计算删除了的
     * @param driverInfo 用户信息
     * @return
     */
    int countUserAcct(DriverInfo driverInfo);
    /**
     * 新增司机信息
     * @param driverInfo
     * @return
     */
    int addUser(DriverInfo driverInfo);
    int addDriver(DriverInfo driverInfo);
    /**
     * 查询司机详情
     * @param driverCode
     * @return
     */
    DriverVO getDriver(@Param("driverCode") String driverCode);
    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    int updateUser(DriverInfo driverInfo);
    int updateDriver(DriverInfo driverInfo);
    /**
     * 查询司机列表
     * @param driverInfo
     * @return
     */
    List<DriverVO> listDriver(DriverInfo driverInfo);
    /**
     * 删除司机信息
     * @param codeList
     * @return
     */
    int deleteUser(CodeList codeList);
    int deleteDriver(CodeList codeList);
}
