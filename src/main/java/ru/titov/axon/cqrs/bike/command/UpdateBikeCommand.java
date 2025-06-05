package ru.titov.axon.cqrs.bike.command;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ru.titov.axon.data.model.types.BikeColor;

import java.util.UUID;

@Value
public class UpdateBikeCommand {
    @TargetAggregateIdentifier
    UUID id;
    String name;
    String description;
    BikeColor color;
}
