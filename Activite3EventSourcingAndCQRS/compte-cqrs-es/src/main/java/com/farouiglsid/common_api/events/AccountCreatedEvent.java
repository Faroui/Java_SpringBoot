package com.farouiglsid.common_api.events;

import com.farouiglsid.common_api.enums.AccountStatus;
import lombok.Getter;

public class AccountCreatedEvent extends BaseEvent<String>{

    @Getter
    private double initialBalance;
    @Getter
    private String currency;

    @Getter
    private AccountStatus accountStatus;
    public AccountCreatedEvent(String id, double initialBalance, String currency, AccountStatus accountStatus) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.accountStatus = accountStatus;
    }
}
