package com.farouiglsid.commands.aggregates;


import com.farouiglsid.common_api.events.AccountActivatedEvent;
import com.farouiglsid.common_api.events.AccountCreditedEvent;
import com.farouiglsid.common_api.events.AccountDebitedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import com.farouiglsid.common_api.commands.CreateAccountCommand;
import com.farouiglsid.common_api.commands.CreditAccountCommand;
import com.farouiglsid.common_api.commands.DebitAccountCommand;
import com.farouiglsid.common_api.enums.AccountStatus;
import com.farouiglsid.common_api.events.AccountCreatedEvent;
import com.farouiglsid.common_api.exceptions.InsufficientBalanceToDebitException;
import com.farouiglsid.common_api.exceptions.InsufficientCreditAmount;
import com.farouiglsid.common_api.exceptions.NegativeAmountException;

import java.util.Date;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate(){

    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){

        if(createAccountCommand.getInitialBalance() < 0) throw new RuntimeException("Invalid Initial Balance");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getInitialBalance(),
                createAccountCommand.getCurrency(),
                AccountStatus.ACTIVATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent accountCreatedEvent){


        this.accountId = accountCreatedEvent.getId();
        this.balance = accountCreatedEvent.getInitialBalance();
        this.currency = accountCreatedEvent.getCurrency();

        this.status = AccountStatus.CREATED;
        AggregateLifecycle.apply(new AccountActivatedEvent(accountCreatedEvent.getId(), AccountStatus.ACTIVATED));
    }
    @EventSourcingHandler
    public void on(AccountActivatedEvent accountActivatedEvent){
        this.status = accountActivatedEvent.getAccountStatus();
    }

    @CommandHandler
    public void handle(CreditAccountCommand creditAccountCommand){
        if(creditAccountCommand.getAmount() <= 100) throw new InsufficientCreditAmount("Credit Amount can not be lower than 100.");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                creditAccountCommand.getId(),
                creditAccountCommand.getAmount(),
                creditAccountCommand.getCurrency(),
                new Date()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent accountCreditedEvent){
        this.balance += accountCreditedEvent.getAmount();
    }


    @CommandHandler
    public void handler(DebitAccountCommand debitAccountCommand){
        if(debitAccountCommand.getAmount() < 0) throw new NegativeAmountException("Amount can't be negative");
        if(this.balance < debitAccountCommand.getAmount()) throw new InsufficientBalanceToDebitException(String.format("Amount must be lower than the balance (%s)", this.balance));
        AggregateLifecycle.apply(new AccountDebitedEvent(
                debitAccountCommand.getId(),
                debitAccountCommand.getAmount(),
                debitAccountCommand.getCurrency(),
                new Date()
        ));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent accountDebitedEvent){
        this.balance -= accountDebitedEvent.getAmount();
    }


}
