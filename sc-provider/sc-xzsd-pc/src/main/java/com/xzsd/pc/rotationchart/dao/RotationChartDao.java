package com.xzsd.pc.rotationchart.dao;

import com.xzsd.pc.rotationchart.entity.RCGoodsVO;
import com.xzsd.pc.rotationchart.entity.RotationChartInfo;
import com.xzsd.pc.rotationchart.entity.RotationChartVO;
import com.xzsd.pc.util.CodeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轮播图管理模块
 * @author asus
 */
@Mapper
public interface RotationChartDao {
    /**
     * 查询相同序号或商品编号的轮播图信息条数
     * @param sortOrdinal
     * @return
     */
    int countSortOrdinal(@Param("goodsCodeint")String goodsCodeint ,@Param("sortOrdinal") int sortOrdinal);
    /**
     * 新增轮播图
     * @param rotationChartInfo
     * @return
     */
    int addRotationChart(RotationChartInfo rotationChartInfo);

    /**
     * 查询商品列表
     * @param rcGoodsVO
     * @return
     */
    List<RCGoodsVO> listGoods(RCGoodsVO rcGoodsVO);

    /**
     * 查询轮播图详情
     * @param rotationChartCode
     * @return
     */
    RotationChartVO getRotationChart(@Param("rotationChartCode") String rotationChartCode);

    /**
     * 查询轮播图列表
     * @param rotationChartInfo
     * @return
     */
    List<RotationChartVO> listRotationChart(RotationChartInfo rotationChartInfo);

    /**
     * 删除轮播图
     * @param codeList
     * @return
     */
    int deleteRotationChart(CodeList codeList);

    /**
     * 修改轮播图状态
     * @param codeList
     * @return
     */
    int updateRotationChartState(CodeList codeList);
}
