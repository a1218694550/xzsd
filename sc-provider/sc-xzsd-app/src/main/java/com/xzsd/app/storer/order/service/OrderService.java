package com.xzsd.app.storer.order.service;

import com.xzsd.app.storer.order.dao.OrderDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
}
