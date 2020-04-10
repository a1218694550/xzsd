package com.xzsd.pc.activermqcustomer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

/**
 * @author asus
 */
@Service
@Component
public class QueueConsumerListener {
    /*@Resource
    private ConsumerDao consumerDao;
    *//**
     * 监听消息
     * @param objectMessage
     * @throws JMSException
     *//*
    @JmsListener(destination="${spring.jms.queue-name}", containerFactory="queueListener")
    public void readActiveQueue(ObjectMessage objectMessage) throws JMSException {
        GoodsInfo goodsInfo = (GoodsInfo) objectMessage.getObject();
        //将对象转为json字符串
        String jsonStr = JsonUtils.toJson(goodsInfo);
        String messageCode = StringUtil.getCommonCode(6);
        //存进数据库
        int result = consumerDao.addMessage(messageCode,jsonStr);
        if (0 == result){
            System.out.println("插入失败");
        }
        System.out.println("queue接受到商品：" + goodsInfo.getGoodsName());
    }*/
}
