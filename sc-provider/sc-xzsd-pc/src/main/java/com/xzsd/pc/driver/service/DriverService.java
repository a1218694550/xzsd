package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
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
        //检查账户是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo); //就算该账户已经给了删除标记也不能加入一样的账户
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账户已存在！");
        }
        //检查手机号绑定账户的个数
        int countPhone = driverDao.countPhone(driverInfo);
        if (0 != countPhone){
            return AppResponse.bizError("该手机号已达绑定上限，请更换绑定手机号！");
        }
        driverInfo.setDriverCode(StringUtil.getCommonCode(6));
        driverInfo.setIsDelete(0);

        int result1 = driverDao.addUser(driverInfo);
        int result2 =  driverDao.addDriver(driverInfo);
        if (0 == result1 || 0 == result2){
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
        //检查账户是否存在
        int countUserAcct = driverDao.countUserAcct(driverInfo); //就算该账户已经给了删除标记也不能加入一样的账户
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账户已存在！");
        }
        //检查手机号绑定账户的个数
        int countPhone = driverDao.countPhone(driverInfo);
        if (0 != countPhone){
            return AppResponse.bizError("该手机号已达绑定上限，请更换绑定手机号！");
        }
        int res0 = driverDao.updateUser(driverInfo);
        int res1 = driverDao.updateDriver(driverInfo);

        if (0 == res0 || 0 == res1){
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
        if (userInfo!=null && userInfo.getRole()!=0){
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
