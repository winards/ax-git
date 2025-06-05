package ru.titov.axon.controller;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.axon.cqrs.bike.command.CreateBikeCommand;
import ru.titov.axon.cqrs.bike.command.DeleteBikeCommand;
import ru.titov.axon.cqrs.bike.command.RentBikeCommand;
import ru.titov.axon.cqrs.bike.command.ReturnBikeCommand;
import ru.titov.axon.cqrs.bike.command.UpdateBikeCommand;
import ru.titov.axon.cqrs.bike.query.AllBikesQuery;
import ru.titov.axon.data.input.bike.BikeCreateInput;
import ru.titov.axon.data.input.bike.DeleteBikeInput;
import ru.titov.axon.data.input.bike.RentBikeInput;
import ru.titov.axon.data.input.bike.ReturnBikeInput;
import ru.titov.axon.data.input.bike.UpdateBikeInput;
import ru.titov.axon.data.view.BikeView;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/bike")
@RequiredArgsConstructor
public class BikeController {

    private final QueryGateway queryGateway;
    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<UUID> createBike(@RequestBody BikeCreateInput input) {
        return commandGateway.send(new CreateBikeCommand(
                UUID.randomUUID(),
                input.getName(),
                input.getDescription(),
                Instant.now()
        ));
    }

    @PostMapping("/rent")
    public CompletableFuture<UUID> rentBike(@RequestBody RentBikeInput input) {
        return commandGateway.send(new RentBikeCommand(
                input.getBikeId(),
                input.getRenterId()
        ));
    }

    @PostMapping("/return")
    public CompletableFuture<UUID> returnBike(@RequestBody ReturnBikeInput input) {
        return commandGateway.send(new ReturnBikeCommand(
                input.getBikeId(),
                input.getMileageRidden()
        ));
    }

    @PostMapping("/update")
    public CompletableFuture<UUID> updateBike(@RequestBody UpdateBikeInput input) {
        return commandGateway.send(new UpdateBikeCommand(
                input.getBikeId(),
                input.getName(),
                input.getDescription(),
                input.getColor()
        ));
    }

    @DeleteMapping
    public CompletableFuture<Void> deleteBike(@RequestBody DeleteBikeInput input) {
        return commandGateway.send(new DeleteBikeCommand(
                input.getBikeId()
        ));
    }

    @GetMapping
    public CompletableFuture<List<BikeView>> bikes() {
        return queryGateway.query(new AllBikesQuery(), ResponseTypes.multipleInstancesOf(BikeView.class));
    }

}
