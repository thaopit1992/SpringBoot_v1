package com.thaopx.RetailStore.service;

import com.thaopx.RetailStore.model.Customer;
import com.thaopx.RetailStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        // encode mật khẩu sang dạng string để lưu vào database
        String pas = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(pas);
        return customerRepository.save(customer);
    }
}
