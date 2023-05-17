package com.leeyaonan.blog.customer.executor.query;

import com.leeyaonan.blog.domain.customer.Customer;
import com.leeyaonan.blog.domain.customer.gateway.CustomerGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerGetByIdQryExe {

    @Autowired
    private CustomerGateway customerGateway;

    public Customer getById() {
        return customerGateway.getById("1");
    }
}
