package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVO;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotGoodsDao {
    /**
     * 展示数量设置
     * @param displayCount
     * @return
     */
    int setDisplayCount(String updater, String displayCount, int version);
    int countSort(int sortOrdinal);
    int countGoods(String goodsCode);
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
    HotGoodsVO getHotGoods(String hotGoodsCode);

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
