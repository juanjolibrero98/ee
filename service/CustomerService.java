package com.juanjoLibrero.trelloApp.service;

import com.juanjoLibrero.trelloApp.persistence.entity.CustomerEntity;
import com.juanjoLibrero.trelloApp.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findByPhone(String phone) {
        return this.customerRepository.findByPhone(phone);
    }
}
