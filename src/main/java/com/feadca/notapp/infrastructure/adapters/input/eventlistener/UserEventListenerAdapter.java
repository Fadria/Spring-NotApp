package com.feadca.notapp.infrastructure.adapters.input.eventlistener;

import com.feadca.notapp.domain.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventListenerAdapter {

    @EventListener
    public void handle(UserCreatedEvent event){
        log.info("User created with id " + event.getId() + " at " + event.getDate());
    }

}
