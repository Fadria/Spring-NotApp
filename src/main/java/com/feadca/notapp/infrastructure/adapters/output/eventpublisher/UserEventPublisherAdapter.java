package com.feadca.notapp.infrastructure.adapters.output.eventpublisher;

import com.feadca.notapp.application.ports.output.UserEventPublisher;
import com.feadca.notapp.domain.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class UserEventPublisherAdapter implements UserEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishUserCreatedEvent(UserCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
