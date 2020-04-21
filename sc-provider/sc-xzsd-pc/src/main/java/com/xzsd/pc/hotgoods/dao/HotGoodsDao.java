package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVO;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 热门商品管理模块
 * @author zehong
 */
@Mapper
public interface HotGoodsDao {
    /**
     * 展示数量设置
     * @param displayCount
     * @return
     */
    int setDisplayCount(@Param("updater") String updater,@Param("displayCount") String displayCount);

    /**
     * 统计序号数量
     * @param sortOrdinal
     * @return
     */
    int countSort(@Param("sortOrdinal") int sortOrdinal);

    /**
     * 统计商品数量
     * @param goodsCode
     * @return
     */
    int countGoods(@Param("goodsCode") String goodsCode);
    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门商品详情
     * @param hotGoodsCode
     * @return
     */
    HotGoodsVO getHotGoods(@Param("hotGoodsCode") String hotGoodsCode);

    /**
     * 修改热门商品
     * @param hotGoodsInfo
     * @return
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门商品列表
     * @param hotGoodsInfo
     * @return
     */
    List<HotGoodsVO> listHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 删除热门商品
     * @param codeList
     * @return
     */
    int deleteHotGoods(CodeList codeList);
}
