package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices{

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<Order> findOrdersWithAdvanceAmount() {
        return orderRepository.findAllByAdvanceamountGreaterThan(0.00);
    }

    @Override
    public Order findOrdersById(long ordernum) throws EntityNotFoundException {

        return orderRepository.findById(ordernum)
                .orElseThrow(() -> new EntityNotFoundException("Order " + ordernum + " is not found "));
    }
}
