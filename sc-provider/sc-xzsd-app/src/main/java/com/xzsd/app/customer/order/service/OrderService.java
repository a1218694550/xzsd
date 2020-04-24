package com.xzsd.app.customer.order.service;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.order.dao.OrderDao;
import com.xzsd.app.customer.order.entity.*;
import com.xzsd.app.util.StringUtil;
import com.xzsd.app.util.SystemValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 订单管理
 * @author asus
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        List<OrderDetails> orderDetailsList = orderDao.listOrderByPage(orderInfo);
        for (int i = 0 ; i <orderDetailsList.size() ; i++ ){
            orderDetailsList.get(i).setClassCount(orderDetailsList.get(i).getGoodsList().size());
        }
        return AppResponse.success("查询订单列表成功",getPageInfo(orderDetailsList));
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    public AppResponse getOrder(String orderCode){
        OrderDetails orderDetails = orderDao.getOrder(orderCode);
        return AppResponse.success("查询订单详情成功！",orderDetails);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        int result = orderDao.updateOrderStatus(orderInfo);
        if (0 == result){
            return AppResponse.bizError("修改订单状态失败!");
        }
        return AppResponse.success("修改订单状态成功!");
    }

    /**
     * 商品评价
     * @param orderEvaluate
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsEvaluate(OrderEvaluate orderEvaluate){
        //查询订单状态
        OrderVO orderDetails = orderDao.getOrderStatus(orderEvaluate.getOrderCode());

        if (Integer.parseInt(orderDetails.getOrderStatus()) != SystemValue.ORDER_STATUS_SUCCESS_VALUE){
            if (Integer.parseInt(orderDetails.getOrderStatus()) < SystemValue.ORDER_STATUS_SUCCESS_VALUE){
                return AppResponse.bizError("评价失败！错误原因：订单未完成");
            }
            else if (Integer.parseInt(orderDetails.getOrderStatus()) == SystemValue.ORDER_STATUS_EVALUETED_VALUE){
                return AppResponse.bizError("评价失败！错误原因：订单已评价");
            }
        }
        String userCode = orderEvaluate.getCustomerCode();
        //初始化评价图片列表
        List<EvaluateImg> evaluateImgList = new ArrayList<>();
        for (int i = 0 ; i < orderEvaluate.getEvaluateList().size() ; i ++){
            //设置评价信息
            orderEvaluate.getEvaluateList().get(i).setEvaluateCode(StringUtil.getCommonCode(6));
            orderEvaluate.getEvaluateList().get(i).setCreater(userCode);
            orderEvaluate.getEvaluateList().get(i).setIsDelete(0);
            //获取评价信息
            EvaluateInfo evaluateInfo = orderEvaluate.getEvaluateList().get(i);
            //设置评价图片信息
            for (int j = 0 ; j < evaluateInfo.getImgUrlList().size(); j ++){
                //获取图片信息
                EvaluateImg evaluateImg = evaluateInfo.getImgUrlList().get(j);
                //设置图片信息
                evaluateImg.setEvaImgCode(StringUtil.getCommonCode(6));
                evaluateImg.setCreater(userCode);
                evaluateImg.setEvaluateCode(evaluateInfo.getEvaluateCode());
                evaluateImg.setIsDelete(0);
                evaluateImgList.add(evaluateImg);
            }
        }
        //修改商品评价星级
        int updateResult = orderDao.updateGoodsStar(orderEvaluate.getEvaluateList());
        if ( 0 == updateResult){
            return AppResponse.bizError("评价失败！修改商品星级失败！");
        }
        //新增评价信息跟评价图片
        int addGoodsEvaResult = orderDao.addGoodsEvaluate(orderEvaluate);
        int addEvaImgResult = orderDao.addEvaluateImg(evaluateImgList);
        if (orderEvaluate.getEvaluateList().size() != addGoodsEvaResult && evaluateImgList.size() != addEvaImgResult){
            return AppResponse.bizError("评价失败，新增评价信息失败！请稍后重试！");
        }
        //设置订单状态为已评价
        OrderInfo orderInfo = new OrderInfo(orderEvaluate.getOrderCode(), SystemValue.ORDER_STATUS_EVALUETED_VALUE,orderEvaluate.getUpdater());
        orderInfo.setVersion(orderDetails.getVersion());
        int updateStatus = orderDao.updateOrderStatus(orderInfo);
        if (0 == updateStatus){
            return AppResponse.bizError("评价失败，数据以变化，订单版本已更新！请稍后重试！");
        }
        return AppResponse.success("评价成功！");
    }
}
