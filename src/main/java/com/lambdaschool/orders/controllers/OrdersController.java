package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class OrdersController {
    //http://localhost:2019/orders/order/7

    @Autowired
    OrderServices orderServices;

    @GetMapping(value = "/advanceamount")
    public ResponseEntity<?> getOrdersWithAdvanceAmount()
    {
        List<Order> myOrderList = orderServices.findOrdersWithAdvanceAmount();
        return new ResponseEntity<>(myOrderList, HttpStatus.OK);
    }

    @GetMapping(value = "/order/{ordernum}", produces = {"application/json"})
    public ResponseEntity<?> getOrderByNumber(@PathVariable long ordernum)
    {
        Order o = orderServices.findOrdersById(ordernum);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}
