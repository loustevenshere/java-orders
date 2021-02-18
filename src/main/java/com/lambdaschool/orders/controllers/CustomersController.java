package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerServices customerServices;

    //   http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myCustomers = customerServices.findAllCustomers();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
//http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{restid}", produces = {"application/json"})
    public ResponseEntity<?> listCustomerById(@PathVariable long restid)
    {
        Customer c = customerServices.findCustomerById(restid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
//http://localhost:2019/customers/customer/77
//http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{custname}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerByName(@PathVariable String custname)
    {
        List<Customer> myCustomers = customerServices.findByCustomerName(custname);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
//http://localhost:2019/customers/namelike/cin

}
