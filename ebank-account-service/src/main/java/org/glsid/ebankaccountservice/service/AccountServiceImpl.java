package org.glsid.ebankaccountservice.service;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import org.glsid.ebankaccountservice.dtos.BankAccountRequestDTO;
import org.glsid.ebankaccountservice.dtos.BankAccountResponseDTO;
import org.glsid.ebankaccountservice.entities.BankAccount;
import org.glsid.ebankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO  bankAccountResponseDTO=BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .type(saveBankAccount.getType())
                .createdAt(saveBankAccount.getCreatedAt())
                .currency(saveBankAccount.getCurrency())
                .balance(saveBankAccount.getBalance())
                .build();
        return null;
    }
}
