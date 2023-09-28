package org.glsid.ebankaccountservice.service;

import org.glsid.ebankaccountservice.dtos.BankAccountRequestDTO;
import org.glsid.ebankaccountservice.dtos.BankAccountResponseDTO;
import org.glsid.ebankaccountservice.entities.BankAccount;
import org.glsid.ebankaccountservice.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO);

    public Boolean deleteAccount(String id);
}
