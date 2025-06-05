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
import ru.titov.axon.cqrs.renter.AllRentersQuery;
import ru.titov.axon.cqrs.renter.command.CreateRenterCommand;
import ru.titov.axon.cqrs.renter.command.DeleteRenterCommand;
import ru.titov.axon.cqrs.renter.command.UpdateRenterCommand;
import ru.titov.axon.data.input.renter.CreateRenterInput;
import ru.titov.axon.data.input.renter.DeleteRenterInput;
import ru.titov.axon.data.input.renter.UpdateRenterInput;
import ru.titov.axon.data.view.RenterView;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/renter")
@RequiredArgsConstructor
public class RenterController {

    private final QueryGateway queryGateway;
    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<UUID> createRenter(@RequestBody CreateRenterInput input) {
        return commandGateway.send(new CreateRenterCommand(
                UUID.randomUUID(),
                input.getName(),
                input.getLastName(),
                input.getAge()
        ));
    }

    @PostMapping("/update")
    public CompletableFuture<UUID> updateRenter(@RequestBody UpdateRenterInput input) {
        return commandGateway.send(new UpdateRenterCommand(
                input.getId(),
                input.getName(),
                input.getLastName(),
                input.getAge()
        ));
    }

    @DeleteMapping
    public CompletableFuture<Void> deleteRenter(@RequestBody DeleteRenterInput input) {
        return commandGateway.send(new DeleteRenterCommand(
                input.getId()
        ));
    }

    @GetMapping
    public CompletableFuture<List<RenterView>> renters() {
        return queryGateway.query(new AllRentersQuery(), ResponseTypes.multipleInstancesOf(RenterView.class));
    }

}
