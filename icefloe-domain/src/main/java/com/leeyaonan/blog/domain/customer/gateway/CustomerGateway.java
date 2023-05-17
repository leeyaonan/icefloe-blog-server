package com.leeyaonan.blog.domain.customer.gateway;

import com.leeyaonan.blog.domain.customer.Customer;

public interface CustomerGateway {
    Customer getById(String customerId);
}
