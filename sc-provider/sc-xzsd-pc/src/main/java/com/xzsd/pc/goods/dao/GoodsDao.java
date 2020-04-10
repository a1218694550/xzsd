package com.xzsd.pc.goods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsVO;
import com.xzsd.pc.goodsclass.entity.GoodsClassOne;
import com.xzsd.pc.goodsclass.entity.GoodsClassSecond;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodsDao {
    /**
     * 查询商品一级分类列表
     * @return
     */
    List<GoodsClassOne> listGoodsClassOne();

    /**
     * 查询商品二级分类列表
     * @param classOneCode
     * @return
     */
    List<GoodsClassSecond> listGoodsClassSecond(String classOneCode);

    /**
     * 新增商品
     * @param goods
     * @return
     */
    int addGoods(GoodsInfo goods);

    /**
     * 查询商品详情
     * @param goodsCode
     * @return
     */
    GoodsVO getGoods(String goodsCode);

    /**
     * 修改商品信息
     * @param goods
     * @return
     */
    int updateGoods(GoodsInfo goods);

    /**
     * 查询商品列表
     * @param goods
     * @return
     */
    List<GoodsVO> listGoods(GoodsInfo goods);

    /**
     * 删除商品接口
     * @param codeList
     * @return
     */
    int deleteGoods(CodeList codeList);

    /**
     * 修改商品状态
     * @param codeList
     * @return
     */
    int updateGoodsStatus(CodeList codeList);
}
