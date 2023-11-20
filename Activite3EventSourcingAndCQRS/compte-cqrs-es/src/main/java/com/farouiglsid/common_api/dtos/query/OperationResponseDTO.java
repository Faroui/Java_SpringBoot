package com.farouiglsid.common_api.dtos.query;

import com.farouiglsid.common_api.enums.OperationType;

import java.util.Date;

public class OperationResponseDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType operationType;
}
