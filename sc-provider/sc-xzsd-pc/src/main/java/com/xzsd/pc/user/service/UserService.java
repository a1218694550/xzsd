package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.StringUtil;
import com.xzsd.pc.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    /**
     * 登录
     * @author zehong
     * @param  userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse login(UserInfo userInfo){
        //登录
        int res = userDao.findUserAcct(userInfo);
        if(0 == res){
            return AppResponse.bizError("登录失败，无此账户信息");
        }
        UserInfo result = userDao.login(userInfo);
        if(null == result){
            return AppResponse.bizError("登录失败，账户密码错误，请检查账户密码是否正确!");
        }
        return AppResponse.success("登录成功！",result);
    }
    /**
     * 新增用户
     * @author zehong
     * @param  userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        //检查账户是否存在
        int countUserAcct = userDao.countUserAcct(userInfo); //就算该账户已经给了删除标记也不能加入一样的账户
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账户已存在！");
        }
        //检查手机号绑定账户的个数
        int countPhone = userDao.countPhone(userInfo);
        if (0 != countPhone){
            return AppResponse.bizError("该手机号已达绑定上限，请更换绑定手机号！");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(6));
        userInfo.setUserPwd(PasswordUtils.generatePassword(userInfo.getUserPwd()));
        userInfo.setIsDelete(0);
        if(userInfo.getUserImg()==null || userInfo.getUserImg()==""){
            userInfo.setUserImg("");
        }
        // 新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 修改用户
     * @author zehong
     * @param  userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo){
        //检查账户是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if (0 != countUserAcct){
            return AppResponse.bizError("用户账户已存在");
        }
        //检查手机号绑定账户的个数
        int countPhone = userDao.countPhone(userInfo);
        if (0 != countPhone){
            return AppResponse.bizError("该手机号已达绑定上限，请更换绑定手机号！");
        }
        // 修改用户
        int count = userDao.updateUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 查询用户详情
     * @author zehong
     * @param  userCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getUser(String userCode){
        // 查询用户
        UserInfo userInfo = userDao.getUser(userCode);
        return AppResponse.success("查询成功！",userInfo);
    }

    /**
     * 删除用户
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(UserInfo userInfo , String userId){
        List<String> listCode = Arrays.asList(userInfo.getUserCode().split(","));

        // 删除用户
        int result = userDao.deleteUser(new CodeList(userId,listCode));
        if (0 == result){
            return AppResponse.bizError("删除失败!");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * 查询用户列表
     * @author zehong
     * @param  userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listUser(UserInfo userInfo){
        // 查询用户列表
        //分页
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        //查询
        List<UserInfo> userList = userDao.listUser(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo(userList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询登录用户信息
     * @author zehong
     * @param  userCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse UserMessage(String userCode){
        // 查询登录用户信息
        UserInfo userInfo = userDao.getUser(userCode);
        return AppResponse.success("查询成功！",userInfo);
    }
}
