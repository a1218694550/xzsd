package com.xzsd.app.util;

public class SystemValue {
    //管理员的数据库值
    public static final int SYSTEM_VALUE_ADMIN = 1;
    //店长的数据库值
    public static final int SYSTEM_VALUE_STORER = 2;
    //顾客的数据库值
    public static final int SYSTEM_VALUE_CUSTOMER = 3;
    //司机的数据库值
    public static final int SYSTEM_VALUE_DRIVER = 4;

    //订单状态 已下单
    public static final int ORDER_STATUS_PLACED_VALUE = 0;
    //订单状态 待取货
    public static final int ORDER_STATUS_WATINGDELIVERY_VALUE = 1;
    //订单状态 已取货
    public static final int ORDER_STATUS_TAKEDELIVERY_VALUE = 2;
    //订单状态 已完成未评价
    public static final int ORDER_STATUS_SUCCESS_VALUE = 3;
    //订单状态 已评价
    public static final int ORDER_STATUS_EVALUETED_VALUE = 4;
    //订单状态 取消
    public static final int ORDER_STATUS_CANCEL_VALUE = 5;
}
