package com.leeyaonan.blog.customer;

import com.leeyaonan.blog.domain.customer.Customer;
import com.leeyaonan.blog.domain.customer.gateway.CustomerGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerGatewayImpl implements CustomerGateway {
    @Autowired
    private CustomerMapper customerMapper;

    public Customer getById(String customerId){
      CustomerDO customerDO = customerMapper.getByById(customerId);
      //Convert to Customer
      return this.convert(customerDO);
    }

    private Customer convert(CustomerDO customerDO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDO.getCustomerId());
        customer.setCompanyName(customerDO.getCompanyName());
        return customer;
    }
}
