package com.xzsd.pc.menu.service;

import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.StringUtil;
import com.xzsd.pc.util.SystemValue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;
    @Resource
    private UserDao userDao;

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    public AppResponse addMenu(MenuInfo menuInfo){
        menuInfo.setMenuCode(StringUtil.getCommonCode(6));
        menuInfo.setIsDelete(0);
        int result = menuDao.addMenu(menuInfo);
        if ( 0 == result){
            return AppResponse.bizError("新增菜单失败！");
        }
        return AppResponse.success("新增菜单成功！");
    }
    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     */
    public AppResponse getMenu(String menuCode){
        MenuVO menuVO = menuDao.getMenu(menuCode);
        if (menuVO==null){
            return AppResponse.bizError("查询菜单详情失败！");
        }
        return AppResponse.success("查询菜单详情成功！",menuVO);
    }
    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    public AppResponse updateMenu(MenuInfo menuInfo){
        int result = menuDao.updateMenu(menuInfo);
        if ( 0 == result){
            return AppResponse.bizError("修改菜单失败！");
        }
        return AppResponse.success("修改菜单成功！");
    }
    /**
     * 查询菜单列表
     * @param operator
     * @return
     */
    public AppResponse listMenu(String operator){
        UserInfo userInfo = userDao.getUser(operator);
        //管理员查全部菜单
        if (SystemValue.SYSTEM_VALUE_ADMIN == userInfo.getRole()){
            List<MenuVO> menuVOList = menuDao.listMenu();
            if (menuVOList!=null){
                return AppResponse.success("查询菜单列表成功!",menuVOList);
            }
        }else if (SystemValue.SYSTEM_VALUE_STORER == userInfo.getRole()){//店长只有固定模块
            List<MenuInfo> menuInfoList = new ArrayList<>();
            menuInfoList.add(new MenuInfo("123456","客户管理",1,null));
            menuInfoList.add(new MenuInfo("123456","订单管理",1,null));
            menuInfoList.add(new MenuInfo("123456","门店管理",1,null));
            menuInfoList.add(new MenuInfo("123456","司机管理",1,null));
            return AppResponse.success("查询菜单列表成功!",menuInfoList);
        }
        return AppResponse.bizError("查询菜单列表失败!");
    }

    /**
     * 修改菜单
     * @param menuCode
     * @param updater
     * @return
     */
    public AppResponse deleteMenu(String menuCode , String updater){
        List<String> menuCodeList = Arrays.asList(menuCode.split(","));
        CodeList codeList = new CodeList(updater,menuCodeList);
        int result = menuDao.deleteMenu(codeList);
        if ( 0 == result){
            return AppResponse.bizError("删除菜单失败！");
        }
        return AppResponse.success("删除菜单成功！");
    }
}
