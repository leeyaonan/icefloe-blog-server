package com.leeyaonan.blog.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.leeyaonan.blog.dto.CustomerAddCmd;
import com.leeyaonan.blog.dto.CustomerListByNameQry;
import com.leeyaonan.blog.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);

    void addCustomer();

    SingleResponse getById();
}
