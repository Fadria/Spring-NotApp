package com.feadca.notapp.application.ports.output;

import com.feadca.notapp.domain.event.UserCreatedEvent;

public interface UserEventPublisher {

    void publishUserCreatedEvent(UserCreatedEvent event);

}
