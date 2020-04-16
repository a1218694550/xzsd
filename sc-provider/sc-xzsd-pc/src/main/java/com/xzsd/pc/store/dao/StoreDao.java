package com.xzsd.pc.store.dao;

import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.store.entity.*;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店管理模块
 * @author zehong
 */
@Mapper
public interface StoreDao {
    /**
     * 查询登录人的角色
     * @param userCode
     * @return
     */
    UserInfo getUser(@Param("userCode")String userCode);
    /**
     * 统计店长编号数量
     * @param storeInfo
     * @return
     */
    int countUserCode(StoreInfo storeInfo);
    int countInvCode(@Param("invCode") String invCode);

    /**
     * 校验营业执照编号
     * @param storeInfo
     * @return
     */
    int countBusLisCode(StoreInfo storeInfo);

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 获取门店详情
     * @param storeCode
     * @return
     */
    StoreVO getStore(@Param("storeCode") String storeCode);

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 查询省市区列表
     * @return
     */
    List<ProvinceInfo> listProvince();
    List<CityInfo> listCity(@Param("provinceCode") String provinceCode);
    List<AreaInfo> listArea(@Param("cityCode") String cityCode);

    /**
     * 查询门店列表
     * @param storeInfo
     * @return
     */
    List<StoreVO> listStore(StoreInfo storeInfo);

    /**
     * 删除门店
     * @param codeList
     * @return
     */
    int deleteStore(CodeList codeList);
}
