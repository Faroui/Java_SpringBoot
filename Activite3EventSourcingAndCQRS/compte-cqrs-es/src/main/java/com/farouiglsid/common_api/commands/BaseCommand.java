package com.farouiglsid.common_api.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<IDType> {
    @TargetAggregateIdentifier
    @Getter
    private IDType id;

    public BaseCommand(IDType id) {
        this.id = id;
    }


}
