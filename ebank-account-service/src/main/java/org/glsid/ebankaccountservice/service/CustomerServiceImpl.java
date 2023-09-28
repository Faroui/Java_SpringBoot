package org.glsid.ebankaccountservice.service;

import org.glsid.ebankaccountservice.entities.Customer;
import org.glsid.ebankaccountservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> customers() {
        return customerRepository.findAll();
    }
}
