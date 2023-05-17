package com.leeyaonan.blog.customer;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.leeyaonan.blog.api.CustomerServiceI;
import com.leeyaonan.blog.customer.executor.CustomerAddCmdExe;
import com.leeyaonan.blog.customer.executor.query.CustomerGetByIdQryExe;
import com.leeyaonan.blog.customer.executor.query.CustomerListByNameQryExe;
import com.leeyaonan.blog.domain.customer.Customer;
import com.leeyaonan.blog.dto.CustomerAddCmd;
import com.leeyaonan.blog.dto.CustomerListByNameQry;
import com.leeyaonan.blog.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    @Resource
    private CustomerGetByIdQryExe customerGetByIdQryExe;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public void addCustomer() {
        customerListByNameQryExe.addCustomer();
    }

    @Override
    public SingleResponse getById() {
        Customer customer = customerGetByIdQryExe.getById();
        CustomerDTO dto = new CustomerDTO();

        dto.setCustomerId(customer.getCustomerId());
        dto.setCompanyName(customer.getCompanyName());
        return SingleResponse.of(dto);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}