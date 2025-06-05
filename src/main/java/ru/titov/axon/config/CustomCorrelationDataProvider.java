package ru.titov.axon.config;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.correlation.CorrelationDataProvider;
import ru.titov.axon.handler.RequestContextFillingFilter;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CustomCorrelationDataProvider implements CorrelationDataProvider {

    public static final String ACCOUNT_ID = "accountId";
    private final RequestContextFillingFilter.RequestContext requestContext;

    @Override
    public Map<String, ?> correlationDataFor(Message<?> message) {
        Map<String, Object> correlationData = new HashMap<>();
        if (message instanceof CommandMessage<?>) {
            correlationData.put(ACCOUNT_ID, requestContext.getAccountId());
        }
        return correlationData;
    }
}
