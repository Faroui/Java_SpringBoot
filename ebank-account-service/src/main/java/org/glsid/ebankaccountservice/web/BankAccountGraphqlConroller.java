package org.glsid.ebankaccountservice.web;

import org.glsid.ebankaccountservice.dtos.BankAccountRequestDTO;
import org.glsid.ebankaccountservice.dtos.BankAccountResponseDTO;
import org.glsid.ebankaccountservice.entities.BankAccount;
import org.glsid.ebankaccountservice.entities.Customer;
import org.glsid.ebankaccountservice.repositories.BankAccountRepository;
import org.glsid.ebankaccountservice.service.AccountService;
import org.glsid.ebankaccountservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BankAccountGraphqlConroller {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
            return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        return accountService.deleteAccount(id);
    }
    @QueryMapping
    public List<Customer> customers(){
            return customerService.customers();
    }
}
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class BankAccountDTO{
//    private String type;
//    private Double balance;
//    private String currency;
//}
/*
instead to create like this class you can use record
record BankAccountDTO(Double balance, String type,String currency){
}*/
