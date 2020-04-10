package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsVO;
import com.xzsd.pc.goodsclass.entity.GoodsClassOne;
import com.xzsd.pc.goodsclass.entity.GoodsClassSecond;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.RedisUtil;
import com.xzsd.pc.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 消息队列
     */
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//    @Autowired
//    private Queue queue;
//    @Autowired
//    private Topic topic;
    /**
     * 查询商品一级分类列表
     * @return
     */
    public AppResponse listGoodsClassOne(){
        List<GoodsClassOne> goodsClassOneList = goodsDao.listGoodsClassOne();
        return AppResponse.success("查询商品一级分类列表成功",goodsClassOneList);
    }

    /**
     * 查询商品二级分类列表
     * @return
     */
    public AppResponse listGoodsClassSecond(String classOneCode){
        List<GoodsClassSecond> goodsClassSecondList = goodsDao.listGoodsClassSecond(classOneCode);
        return AppResponse.success("查询商品属于该一级分类的二级分类列表成功",goodsClassSecondList);
    }

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goods){
        goods.setGoodsCode(StringUtil.getCommonCode(6));
        goods.setIsDelete(0);
        if (goods.getImage() == null || goods.getImage() == ""){
            goods.setImage("https://book-store-1300963863.cos.ap-guangzhou.myqcloud.com/book-store/2020/2/29/223ceba3-59e0-419f-a306-5c3a5d363bbc.ico");
        }
        int result = goodsDao.addGoods(goods);
        if ( 0 == result){
            return AppResponse.bizError("新增商品失败");
        }
//        //MQ发送消息
//        try {
//            jmsMessagingTemplate.convertAndSend(queue, goods);
//            System.out.println("消息发送成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return AppResponse.success("新增商品成功");
    }

    /**
     * 查询商品详情
     * @param goodsCode
     * @return
     */
    public AppResponse getGoods(String goodsCode){
        GoodsVO goods = goodsDao.getGoods(goodsCode);
        return AppResponse.success("查询成功",goods);
    }

    /**
     * 修改商品详情
     * @param goods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goods){
        int result = goodsDao.updateGoods(goods);
        if ( 0 == result){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 查询商品列表
     * @param goods
     * @return
     */
    public AppResponse listGoods(GoodsInfo goods){
        String key =goods.getGoodsName()+"-"+goods.getGoodsStatus()+"-"+goods.getAdvWords()+goods.getPress()
                +"-"+goods.getAuthor()+"-"+goods.getPageNum()+"-"+goods.getPageSize();
        PageInfo<GoodsVO> pageData;
        PageHelper.startPage(goods.getPageNum(), goods.getPageSize());
        //查询
        List<GoodsVO> goodsList = goodsDao.listGoods(goods);
        // 包装Page对象
        pageData = new PageInfo(goodsList);
        return AppResponse.success("从mysql查询商品列表成功",pageData);
        //redis操作演示
        /*if(redisUtil.hasKey(key)){ //如果redis存在这个数据则从redis取
            System.out.println("从redis取出");
            pageData = (PageInfo<GoodsVO>)redisUtil.get(key);
            //将json字符串转为对象
//            pageData = JsonUtils.fromJson(redisUtil.get(key),PageInfo.class);
            return AppResponse.success("从redis查询商品列表成功",pageData);
        }else { //否则查询数据库
            PageHelper.startPage(goods.getPageNum(), goods.getPageSize());
            //查询
            List<GoodsVO> goodsList = goodsDao.listGoods(goods);
            // 包装Page对象
            pageData = new PageInfo(goodsList);
            //使用json 将对象转为json字符串
//            String json = JsonUtils.toJson(pageData);
            key = goods.getGoodsName() + "-" + goods.getGoodsStatus() + "-" + goods.getAdvWords() + goods.getPress()
                    + "-" + goods.getAuthor() + "-" + goods.getPageNum() + "-" + goods.getPageSize();
            if (redisUtil.set(key, pageData ,60*5)) {
                System.out.println("放入redis成功");
            }
            return AppResponse.success("从mysql查询商品列表成功",pageData);
        }
*/
    }
    /**
     * 删除商品
     * @param goodsCode
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode , String updater){
        List<String> goodsCodeList = Arrays.asList(goodsCode.split(","));
        int result = goodsDao.deleteGoods(new CodeList(updater,goodsCodeList));
        if ( 0 == result){
            return AppResponse.bizError("删除商品失败");
        }
        return AppResponse.success("删除商品成功");
    }

    /**
     * 修改商品状态
     * @param goodsCode
     * @param goodsStatus
     * @param updater
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsStatus(String goodsCode , String goodsStatus, String updater){
        List<String> goodsCodeList = Arrays.asList(goodsCode.split(","));
        if (Integer.valueOf(goodsStatus) == 1 || Integer.valueOf(goodsStatus) == 2 || Integer.valueOf(goodsStatus) == 3){
            return AppResponse.bizError("修改商品状态失败,参数 goodsStatus 错误，2上架 3下架 1未发布");
        }
        int result = goodsDao.updateGoodsStatus(new CodeList(updater,goodsCodeList,goodsStatus));
        if ( 0 == result){
            return AppResponse.bizError("修改商品状态失败");
        }
        return AppResponse.success("修改商品状态成功");
    }
}
