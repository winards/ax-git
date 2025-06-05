package ru.titov.axon.projection;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import ru.titov.axon.cqrs.renter.AllRentersQuery;
import ru.titov.axon.cqrs.renter.event.RenterCreatedEvent;
import ru.titov.axon.cqrs.renter.event.RenterDeletedEvent;
import ru.titov.axon.cqrs.renter.event.RenterUpdatedEvent;
import ru.titov.axon.data.model.EntityMapper;
import ru.titov.axon.data.model.Renter;
import ru.titov.axon.data.repository.RenterRepository;
import ru.titov.axon.data.view.RenterView;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RenterProjection {

    private final EntityMapper mapper;
    private final RenterRepository repository;

    @EventHandler
    public void on(RenterCreatedEvent event) {
        repository.save(mapper.map(event));
    }

    @EventHandler
    public void on(RenterUpdatedEvent event) {
        Renter renterFromDb = repository.findById(event.getId())
                .orElseThrow(() -> new EntityNotFoundException("Renter with id not found " + event.getId()));
        Renter renterFromEvent = mapper.map(event);

        Renter result = mapper.merge(renterFromEvent, renterFromDb);
        repository.save(result);
    }

    @EventHandler
    public void on(RenterDeletedEvent event) {
        repository.deleteById(event.getId());
    }

    @QueryHandler
    public List<RenterView> handle(AllRentersQuery query) {
        return repository.findAll().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

}
