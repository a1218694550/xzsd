package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 新增司机信息
     * @param driverInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo){
        //检查账户和手机号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账户已存在,或该手机号已达绑定上限！");
        }
        driverInfo.setDriverCode(StringUtil.getCommonCode(6));
        driverInfo.setDriverPassword(PasswordUtils.generatePassword(driverInfo.getDriverPassword()));
        driverInfo.setIsDelete(0);
        int resultUser = driverDao.addUser(driverInfo);
        int resultDriver =  driverDao.addDriver(driverInfo);
        if (0 == resultUser || 0 == resultDriver){
            return AppResponse.bizError("新增司机失败！");
        }
        return AppResponse.success("新增司机成功",driverInfo.getDriverCode());
    }

    /**
     * 查询司机详情
     * @param driverCode
     * @return
     */
    public AppResponse getDriver(String driverCode){
        DriverVO driverVO= driverDao.getDriver(driverCode);
        return AppResponse.success("查询司机成功!",driverVO);
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo){
        //检查账户和手机号是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo);
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账户已存在,或该手机号已达绑定上限！");
        }
        driverInfo.setDriverPassword(PasswordUtils.generatePassword(driverInfo.getDriverPassword()));
        int resUser = driverDao.updateUser(driverInfo);
        int resDriver = driverDao.updateDriver(driverInfo);
        if (0 == resUser || 0 == resDriver){
            return AppResponse.bizError("修改司机信息失败");
        }
        return AppResponse.success("修改司机信息成功",driverInfo.getDriverCode());
    }
    /**
     * 查询司机列表
     * @param driverInfo
     * @return
     */
    public AppResponse listDriver(DriverInfo driverInfo){
        UserInfo userInfo = driverDao.getUser(driverInfo.getOperator());
        if (userInfo != null && userInfo.getRole() != 0){
            driverInfo.setRole(userInfo.getRole());
        }
        PageHelper.startPage(driverInfo.getPageNum(),driverInfo.getPageSize());
        List<DriverVO> driverVOList = driverDao.listDriver(driverInfo);
        PageInfo<DriverVO> pageDate = new PageInfo<>(driverVOList);

        return AppResponse.success("查询司机列表成功!",pageDate);
    }

    /**
     * 删除司机信息
     * @param driverCode
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverCode , String updater){
        List<String> driverCodeList = Arrays.asList(driverCode.split(","));
        int result1 = driverDao.deleteUser(new CodeList(updater,driverCodeList));
        int result2 = driverDao.deleteDriver(new CodeList(updater,driverCodeList));
        if (0 == result1 || 0 ==result2){
            return AppResponse.bizError("删除司机信息失败！");
        }
        return AppResponse.success("删除司机信息成功！");
    }
}
