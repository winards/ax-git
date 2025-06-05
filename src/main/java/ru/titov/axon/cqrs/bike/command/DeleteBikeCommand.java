package ru.titov.axon.cqrs.bike.command;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Value
public class DeleteBikeCommand {
    @TargetAggregateIdentifier
    UUID id;
}
