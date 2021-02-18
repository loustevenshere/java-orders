package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



    @Transactional
    @Service(value = "customerServices")
    public class CustomerServicesImpl implements CustomerServices {

        @Autowired
        private CustomerRepository custrepos;



    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

        @Override
        public Customer findCustomerById(long restid) {
            return custrepos.findById(restid)
                    .orElseThrow(() -> new EntityNotFoundException("Restaurant " +
                            restid + " is not found "));
        }

        @Override
        public List<Customer> findByCustomerName(String custname) {
            return custrepos.findByCustnameContainingIgnoringCase(custname);
        }
    }
