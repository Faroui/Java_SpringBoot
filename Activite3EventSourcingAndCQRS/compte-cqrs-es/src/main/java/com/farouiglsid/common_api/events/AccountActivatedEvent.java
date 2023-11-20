package com.farouiglsid.common_api.events;

import lombok.Getter;
import com.farouiglsid.common_api.enums.AccountStatus;

public class AccountActivatedEvent  extends BaseEvent<String> {

    @Getter
    private AccountStatus accountStatus;

    public AccountActivatedEvent(String s, AccountStatus accountStatus) {
        super(s);
        this.accountStatus = accountStatus;
    }
}
