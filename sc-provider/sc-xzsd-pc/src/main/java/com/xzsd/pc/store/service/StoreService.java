package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.*;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.RandomUtil;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo){
        String invCode = RandomUtil.getRandomString(6);
        //校验门店邀请码
        int countInv = storeDao.countInvCode(invCode);
        if( 0 != countInv){
            return AppResponse.bizError("新增门店失败，随机生成邀请码失败!");
        }
        storeInfo.setStoreCode(StringUtil.getCommonCode(6));
        storeInfo.setInvCode(invCode);
        storeInfo.setIsDelete(0);
        /**
         * 校验营业执照
         */
        int countBusLisCode = storeDao.countBusLisCode(storeInfo);
        if( 0 != countBusLisCode){
            return AppResponse.bizError("新增门店失败，该营业执照已存在!");
        }
        /**
         * 校验店长编号
         */
        int countUserCode = storeDao.countUserCode(storeInfo);
        if( 0 == countUserCode){
            return AppResponse.bizError("新增门店失败，该店长编号不存在!");
        }
        //新增门店
        int result = storeDao.addStore(storeInfo);
        if( 0 == result){
            return AppResponse.bizError("新增门店失败!");
        }

        return AppResponse.success("新增门店成功!");
    }

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     */
    public AppResponse getStore(String storeCode){
        StoreVO storeVO = storeDao.getStore(storeCode);

        return AppResponse.success("查询门店详情成功!",storeVO);
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo){
        /**
         * 校验营业执照
         */
        int countBusLisCode = storeDao.countBusLisCode(storeInfo);
        if( 0 != countBusLisCode){
            return AppResponse.bizError("修改门店失败，该营业执照已存在!");
        }
        /**
         * 校验店长编号
         */
        int countUserCode = storeDao.countUserCode(storeInfo);
        if( 0 == countUserCode){
            return AppResponse.bizError("修改门店失败，该店长编号不存在!");
        }
        int result = storeDao.updateStore(storeInfo);
        if( 0 == result){
            return AppResponse.bizError("修改门店失败!");
        }
        return AppResponse.success("修改门店成功!");
    }
    /**
     * 查询省市区列表
     * @return
     */
    public AppResponse listProvince(){
        List<ProvinceInfo> provinceInfoList = storeDao.listProvince();

        return AppResponse.success("查询省份列表成功!",provinceInfoList);
    }
    public AppResponse listCity(String provinceCode){
        List<CityInfo> cityInfoList = storeDao.listCity(provinceCode);

        return AppResponse.success("查询城市列表成功!",cityInfoList);
    }
    public AppResponse listArea(String cityCode){
        List<AreaInfo> areaInfoList = storeDao.listArea(cityCode);

        return AppResponse.success("查询区列表成功!",areaInfoList);
    }

    /**
     * 查询门店列表
     * @param storeInfo
     * @return
     */
    public AppResponse listStore(StoreInfo storeInfo){
        //获取当前登录人的角色
        UserInfo userInfo = storeDao.getUser(storeInfo.getOperator());
        if (userInfo != null && userInfo.getRole()!=0){
            storeInfo.setRole(userInfo.getRole());
        }
        System.out.println(storeInfo.getRole());
        //查询门店列表 如果登录人是管理员，查询所有门店 ； 如果登录人是店长，则查询该店长所有的门店
        PageHelper.startPage(storeInfo.getPageNum(),storeInfo.getPageSize());
        List<StoreVO> storeVOList = storeDao.listStore(storeInfo);
        PageInfo<StoreVO> pageData = new PageInfo<>(storeVOList);

        return AppResponse.success("查询门店列表成功！",pageData);
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeCode , String updater){
        List<String> storeCodeList = Arrays.asList(storeCode.split(","));

        int result = storeDao.deleteStore(new CodeList(updater,storeCodeList));
        if( 0 == result){
            return AppResponse.bizError("删除门店失败!");
        }
        return AppResponse.success("删除门店成功!");
    }
}
