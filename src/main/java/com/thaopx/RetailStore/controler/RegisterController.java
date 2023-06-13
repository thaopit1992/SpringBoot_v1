package com.thaopx.RetailStore.controler;

import com.thaopx.RetailStore.model.Customer;
import com.thaopx.RetailStore.model.Greeting;
import com.thaopx.RetailStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RegisterController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer){
        ResponseEntity<String> response = null;
        try{
            Customer savedCustomer = customerService.createCustomer(customer);
            if(savedCustomer.getId() > 0 ){
                response = ResponseEntity.status(HttpStatus.CREATED).body("Lưu thành công customer : " + customer.getUsername());
            }
        } catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception :" + e);
        }
        return response;
    }
}
