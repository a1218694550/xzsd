package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className UserDao
 * @Description Demo
 * @Author zehong
 * @Date 2020-03-21
 */
@Mapper
public interface UserDao{
    /**
     * 统计用户账号数量 计算删除了的
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户详情
     * @param userCode
     * @return
     */
    UserInfo getUser(@Param("userCode") String userCode);

    /**
     * 删除用户
     * @param codeList
     * @return
     */
    int deleteUser(CodeList codeList);

    /**
     * 分页查询用户列表
     * @param userInfo
     * @return
     */
    List<UserInfo> listUser(UserInfo userInfo);
}
