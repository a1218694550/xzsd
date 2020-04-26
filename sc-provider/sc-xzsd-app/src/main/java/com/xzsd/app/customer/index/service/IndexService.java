package com.xzsd.app.customer.index.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.customer.index.dao.IndexDao;
import com.xzsd.app.customer.index.entity.CustomerInfo;
import com.xzsd.app.customer.index.entity.HotGoodsVO;
import com.xzsd.app.customer.index.entity.RotationChartVO;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexService {
    @Resource
    private IndexDao indexDao;
    /**
     * 注册账号
     * @param customerInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCustomer(CustomerInfo customerInfo){
        //如果邀请码不为空，则校验邀请码
        if (customerInfo.getInvCode() != null && "".equals(customerInfo.getInvCode())){
            //校验邀请码
            int result = indexDao.findInvCode(customerInfo.getInvCode());
            if ( 0 == result){
                return AppResponse.bizError("注册失败，邀请码错误!");
            }
        }
        //校验账号
        int countUser = indexDao.countUserAcct(customerInfo);
        if (0 != countUser){
            return AppResponse.bizError("注册失败，该账号或手机号已存在!");
        }
        //新增账号
        customerInfo.setUserCode(StringUtil.getCommonCode(6));
        customerInfo.setIsDelete(0);
        //设置默认图片
        if (customerInfo.getUserImg() == null || "".equals(customerInfo.getUserImg())){
            customerInfo.setUserImg("https://book-store-1300963863.cos.ap-guangzhou.myqcloud.com/book-store/2020/2/29/223ceba3-59e0-419f-a306-5c3a5d363bbc.ico");
        }
        //密码加密
        customerInfo.setPassword(PasswordUtils.generatePassword(customerInfo.getPassword()));

        int addUserRes = indexDao.addUser(customerInfo);
        int addCustRes = indexDao.addCustomer(customerInfo);
        if (addUserRes == 0 || addCustRes == 0){
            return AppResponse.bizError("注册失败");
        }
        return AppResponse.success("注册成功");
    }

    /**
     * 查询轮播图列表
     * @return
     */
    public AppResponse listRotationChart(){
        List<RotationChartVO> rotationChartVOList = indexDao.listRotationChart();
        if (rotationChartVOList==null){
            return AppResponse.bizError("查询轮播图列表失败！");
        }
        return AppResponse.success("查询轮播图列表成功!",rotationChartVOList);
    }

    /**
     * 查询热门商品列表
     * @return
     */
    public AppResponse listHotGoods(){
        int displayCount = Integer.valueOf(indexDao.getDisPlayCount());
        List<HotGoodsVO> hotGoodsVOList = indexDao.listHotGoods(displayCount);
        if (hotGoodsVOList==null){
            return AppResponse.bizError("查询热门商品列表失败！");
        }
        return AppResponse.success("查询热门商品列表成功!",hotGoodsVOList);
    }
}
