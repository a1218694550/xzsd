package com.xzsd.app.storer.order.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.customer.order.entity.OrderDetails;
import com.xzsd.app.customer.order.entity.OrderInfo;
import com.xzsd.app.storer.order.dao.StorerOrderDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class StorerOrderService {
    @Resource
    private StorerOrderDao stoereOrderDao;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        //设置门店编号
        String storeCode = stoereOrderDao.getStore(orderInfo.getStorerCode()).getStoreCode();
        orderInfo.setStoreCode(storeCode);
        List<OrderDetails> orderDetailsList = stoereOrderDao.listOrderByPage(orderInfo);
        for (int i = 0 ; i <orderDetailsList.size() ; i++ ){
            //设置订单商品种类数量
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
        OrderDetails orderDetails = stoereOrderDao.getOrder(orderCode);
        return AppResponse.success("查询订单详情成功！",orderDetails);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        int result = stoereOrderDao.updateOrderStatus(orderInfo);
        if (0 == result){
            return AppResponse.bizError("修改订单状态失败!");
        }
        return AppResponse.success("修改订单状态成功!");
    }
}
