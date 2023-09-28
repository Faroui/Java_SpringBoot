package org.glsid.ebankaccountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.glsid.ebankaccountservice.enums.AccountType;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
