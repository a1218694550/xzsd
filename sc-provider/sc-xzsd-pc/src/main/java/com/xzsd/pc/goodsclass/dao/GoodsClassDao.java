package com.xzsd.pc.goodsclass.dao;

import com.xzsd.pc.goodsclass.entity.GoodsClassInfo;
import com.xzsd.pc.goodsclass.entity.GoodsClassOne;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 商品分类管理模块
 * @author zehong
 */
@Mapper
public interface GoodsClassDao {
    /**
     * 新增商品分类
     * @param goodsClassInfo
     * @return
     */
    int addGoodsClass(GoodsClassInfo goodsClassInfo);

    /**
     * 查询商品详情
     * @param goodsClassInfo
     * @return
     */
    GoodsClassInfo getGoodsClass(GoodsClassInfo goodsClassInfo);

    /**
     * 修改商品分类
     * @param goodsClassInfo
     * @return
     */
    int updateGoodsClass(GoodsClassInfo goodsClassInfo);

    /**
     * 查询商品分类列表
     * @return
     */
    List<GoodsClassOne> listGoodsClass();

    /**
     * 查询分类下二级分类的数量
     * @param classCode
     * @return
     */
    int countChildClass(@Param("classCode") String classCode);

    /**
     * 查询二级分类下商品数量
     * @param classCode
     * @return
     */
    int countGoods(@Param("classCode") String classCode);
    /**
     * 删除商品分类
     * @param goodsClassInfo
     * @return
     */
    int deleteGoodsClass(GoodsClassInfo goodsClassInfo);
}
