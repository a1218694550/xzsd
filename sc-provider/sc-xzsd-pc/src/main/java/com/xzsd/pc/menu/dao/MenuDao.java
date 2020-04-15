package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    int addMenu(MenuInfo menuInfo);
    MenuVO getMenu(@Param("menuCode") String menuCode);
    int updateMenu(MenuInfo menuInfo);
    /**
     * 查询菜单列表接口
     * @return
     */
    List<MenuVO> listMenu();

    int deleteMenu(CodeList codeList);
}
