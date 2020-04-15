package com.xzsd.app.customer.goodsDetail.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.customer.goodsDetail.dao.GoodsDetailDao;
import com.xzsd.app.customer.goodsDetail.entity.*;
import com.xzsd.app.customer.shopcart.dao.ShopCartDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class GoodsDetailService {
    @Resource
    private GoodsDetailDao goodsDetailDao;
    @Resource
    private ShopCartDao shopCartDao;
    /**
     * 查询商品详情
     * @param goodsCode
     * @param userCode
     * @return
     */
    public AppResponse getGoods(String goodsCode , String userCode){
        StoreVO storeVO = goodsDetailDao.getStoreOfUser(userCode);
        GoodsVO goodsVO = goodsDetailDao.getGoods(goodsCode);
        if (storeVO.getDetailedAddress()==null || "".equals(storeVO.getDetailedAddress())){
            storeVO.setDetailedAddress("地址发生未知错误!请检查绑定门店或询问门店店长详情！");
        }
        goodsVO.setAddress(storeVO.getDetailedAddress());
        return AppResponse.success("查询商品详情成功！",goodsVO);
    }

    /**
     * 加入购物车
     * @param opeGoods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsToCart(OpeGoods opeGoods){
        //生成购物车编号
        opeGoods.setShopCartCode(StringUtil.getCommonCode(6));
        //获取购买的商品信息
        GoodsVO goodsVO = goodsDetailDao.getGoods(opeGoods.getGoodsCode());
        if (goodsVO==null){
            return AppResponse.bizError("获取商品信息失败，添加失败!");
        }
        //设置购买的商品总价
        opeGoods.setSumPrice(goodsVO.getSellPrice()*opeGoods.getCount());
        opeGoods.setIsDelete(0);
        int result = goodsDetailDao.addGoodsToCart(opeGoods);
        if ( 0 == result){
            return AppResponse.bizError("非常抱歉，添加失败!");
        }
        return AppResponse.success("添加商品至购物车成功！");
    }

    /**
     * 购买商品
     * @param addOrderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(AddOrderInfo addOrderInfo){
        List<String> goodsList = Arrays.asList(addOrderInfo.getGoodsCode().split(","));
        List<String> countList = Arrays.asList(addOrderInfo.getCount().split(","));
        //设置订单信息
        String orderCode =  StringUtil.getCommonCode(6);
        addOrderInfo.setOrderCode(orderCode);
        addOrderInfo.setSumPrice(0);
        addOrderInfo.setStoreCode(goodsDetailDao.getStoreOfUser(addOrderInfo.getUserCode()).getStoreCode());
        //构建订单详情列表
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        String create = addOrderInfo.getUserCode();
        //生成订单详情信息
        for (int i = 0 ; i < goodsList.size() ; i++){
            String orderDetailsCode = StringUtil.getCommonCode(6);
            float price = goodsDetailDao.getGoods(goodsList.get(i)).getSellPrice();
            OrderDetails orderDetails = new OrderDetails(orderDetailsCode,goodsList.get(i),Integer.parseInt(countList.get(i)),price);
            orderDetails.setCreater(create);
            orderDetails.setIsDelete(0);
            orderDetails.setOrderCode(orderCode);
            //计算总价
            addOrderInfo.setSumPrice(addOrderInfo.getSumPrice()+price*Integer.parseInt(countList.get(i)));
            //添加至list
            orderDetailsList.add(orderDetails);
        }
        //新增订单
        int resAddOrder = goodsDetailDao.addOrder(addOrderInfo);
        if ( 0 == resAddOrder){
            return AppResponse.bizError("购买失败！");
        }
        //新增订单详情
        int resAddOrderDetails = goodsDetailDao.addOrderDetail(orderDetailsList);
        if ( goodsList.size() != resAddOrderDetails){
            return AppResponse.bizError("购买失败！");
        }
        //修改商品库存跟销量
        int resUpdateGoods = goodsDetailDao.updateGoods(orderDetailsList);
        System.out.println("result-----> "+resUpdateGoods);
        if (0 == resUpdateGoods){
            return AppResponse.bizError("购买失败！");
        }
        //如果是在购物车点的结算 ， 则需要将商品移除购物车
        if (addOrderInfo.getShopCartCode()!=null && !"".equals(addOrderInfo.getShopCartCode())){
            List<String> shopCartCodeList = Arrays.asList(addOrderInfo.getShopCartCode().split(","));
            int resultDelete = shopCartDao.deleteGoods(shopCartCodeList,addOrderInfo.getUserCode());
            if (0 == resultDelete){
                return AppResponse.bizError("移除购物车失败，购买失败！");
            }
        }
        return AppResponse.success("购买商品成功！");
    }

    /**
     * 查询商品评价列表
     * @param goodsEvaluateInfo
     * @return
     */
    public AppResponse listGoodsEvaluateByPage(GoodsEvaluateInfo goodsEvaluateInfo){
        List<GoodsEvaluateVO> goodsEvaluateVOList = goodsDetailDao.listGoodsEvaluateByPage(goodsEvaluateInfo);
//        List<ImageInfo> imageInfoList = goodsDetailDao.listGoodsEvaluateImage(goodsEvaluateVOList);
//        int start;
//        for (int i = 0; i < goodsEvaluateVOList.size(); i++) {
//            String evaluateCode = goodsEvaluateVOList.get(i).getEvaluateCode();
//            List<ImageInfo> list = new ArrayList<>();
//            start = 0 ;
//            for (int j = 0 ; j < imageInfoList.size() ; j ++){
//                if (evaluateCode.equals(imageInfoList.get(j).getEvaluateCode())){
//                    list.add(imageInfoList.get(j));
//                    if (start == 0){
//                        start = 1;
//                    }
//                }else {
//                    if (start == 1){
//                        break;
//                    }
//                }
//            }
//            goodsEvaluateVOList.get(i).setListImgUrl(list);
//        }
        return AppResponse.success("查询商品评价列表成功！",getPageInfo(goodsEvaluateVOList));
    }
}
