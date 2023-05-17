package com.leeyaonan.blog.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.leeyaonan.blog.api.CustomerServiceI;
import com.leeyaonan.blog.dto.CustomerAddCmd;
import com.leeyaonan.blog.dto.CustomerListByNameQry;
import com.leeyaonan.blog.dto.data.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "CustomerController")
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @Operation(summary = "helloworld")
    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to COLA world!";
    }

    @Operation(summary = "customer1")
    @GetMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomerByName(@RequestParam(required = false) String name){
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }

    @Operation(summary = "customer2")
    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        return customerService.addCustomer(customerAddCmd);
    }

    @Operation(summary = "getById")
    @PostMapping(value = "/getById")
    public SingleResponse getById(){
        return customerService.getById();
    }
}
