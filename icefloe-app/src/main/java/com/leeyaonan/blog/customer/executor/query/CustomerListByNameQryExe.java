package com.leeyaonan.blog.customer.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.leeyaonan.blog.domain.customer.gateway.CustomerGateway;
import com.leeyaonan.blog.dto.CustomerListByNameQry;
import com.leeyaonan.blog.dto.data.CustomerDTO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerListByNameQryExe{

    @Autowired
    private CustomerGateway customerGateway;

    public MultiResponse<CustomerDTO> execute(CustomerListByNameQry cmd) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("Frank");
        customerDTOList.add(customerDTO);
        return MultiResponse.of(customerDTOList);
    }

    public void addCustomer() {
    }

}
