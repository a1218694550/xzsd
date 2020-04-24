package com.xzsd.app.customer.goodsclass.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.goodsclass.dao.AppGoodsClassDao;
import com.xzsd.app.customer.goodsclass.entity.GoodsClassOne;
import com.xzsd.app.customer.goodsclass.entity.GoodsClassSecond;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppGoodsClassService {
    @Resource
    private AppGoodsClassDao goodsClassDao;
    /**
     * 查询商品一级分类列表
     * @return
     */
    public AppResponse listGoodsClassOne(){
        List<GoodsClassOne> goodsClassOneList = goodsClassDao.listGoodsClassOne();
        return AppResponse.success("查询商品一级分类列表成功!",goodsClassOneList);
    }

    /**
     * 查询商品二级分类以及分类下的商品列表
     * @param classOneCode
     * @return
     */
    public AppResponse listGoodsSecondAndGoods(String classOneCode){
        List<GoodsClassSecond> List = goodsClassDao.listGoodsSecondAndGoods(classOneCode);
        return AppResponse.success("查询商品二级分类以及分类下的商品列表成功!",List);
    }
}
