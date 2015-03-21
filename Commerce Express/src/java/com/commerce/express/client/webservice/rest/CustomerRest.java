package com.commerce.express.client.webservice.rest;

import com.commerce.express.client.webservice.rest.assembler.CustomerAssembler;
import com.commerce.express.client.webservice.rest.resources.CustomerResource;
import com.commerce.express.domain.Customer;
import com.commerce.express.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cna canal walk
 */
@Controller
@RequestMapping("customer")
public class CustomerRest {
    
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerAssembler customerAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CustomerResource>> getAppoint() {
        List<Customer> customer = customerService.getAllCustomer();
        List<CustomerResource> resource = customerAssembler.toResources(customer);
        return new ResponseEntity<List<CustomerResource>>(resource, HttpStatus.OK);
    }
}
