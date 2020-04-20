package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单管理模块
 * @author 泽宏
 */
public interface MenuDao {
    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    int addMenu(MenuInfo menuInfo);

    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     */
    MenuVO getMenu(@Param("menuCode") String menuCode);

    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    int updateMenu(MenuInfo menuInfo);
    /**
     * 查询菜单列表接口
     * @return
     */
    List<MenuVO> listMenu(@Param("role") int role);

    /**
     * 删除菜单
     * @param codeList
     * @return
     */
    int deleteMenu(CodeList codeList);
}
