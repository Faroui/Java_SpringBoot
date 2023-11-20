package com.farouiglsid.query.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.farouiglsid.common_api.enums.OperationType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @Builder
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double amount;

    @Enumerated(EnumType.STRING)
    private OperationType type;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
