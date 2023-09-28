package org.glsid.ebankaccountservice.service;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import org.glsid.ebankaccountservice.dtos.BankAccountRequestDTO;
import org.glsid.ebankaccountservice.dtos.BankAccountResponseDTO;
import org.glsid.ebankaccountservice.entities.BankAccount;
import org.glsid.ebankaccountservice.mappers.AccountMapper;
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
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO  bankAccountResponseDTO=accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getType()!=null)bankAccount.setType(bankAccountDTO.getType());
        if(bankAccount.getBalance()!=null)bankAccount.setBalance(bankAccountDTO.getBalance());
        if(bankAccount.getCurrency()!=null)bankAccount.setCurrency(bankAccountDTO.getCurrency());
        if (bankAccount.getCreatedAt()!=null)bankAccount.setCreatedAt(new Date());
        return accountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public Boolean deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }
}
