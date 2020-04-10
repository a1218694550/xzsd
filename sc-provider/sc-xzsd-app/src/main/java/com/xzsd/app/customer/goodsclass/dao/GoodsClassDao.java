package com.xzsd.app.customer.goodsclass.dao;

import com.xzsd.app.customer.goodsclass.entity.GoodsClassOne;
import com.xzsd.app.customer.goodsclass.entity.GoodsClassSecond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsClassDao {
    /**
     * 查询商品一级分类列表
     * @return
     */
    List<GoodsClassOne> listGoodsClassOne();

    /**
     * 查询商品二级分类以及分类下的商品列表
     * @param classOneCode
     * @return
     */
    List<GoodsClassSecond> listGoodsSecondAndGoods(String classOneCode);
}
