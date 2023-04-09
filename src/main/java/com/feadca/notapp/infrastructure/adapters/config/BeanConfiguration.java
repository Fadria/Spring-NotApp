package com.feadca.notapp.infrastructure.adapters.config;

import com.feadca.notapp.domain.service.UserService;
import com.feadca.notapp.infrastructure.adapters.output.eventpublisher.UserEventPublisherAdapter;
import com.feadca.notapp.infrastructure.adapters.output.persistence.UserPersistenceAdapter;
import com.feadca.notapp.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import com.feadca.notapp.infrastructure.adapters.output.persistence.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserPersistenceAdapter userPersistenceAdapter(UserRepository userRepository, UserPersistenceMapper userPersistenceMapper) {
        return new UserPersistenceAdapter(userRepository, userPersistenceMapper);
    }

    @Bean
    public UserEventPublisherAdapter userEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new UserEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public UserService userService(UserPersistenceAdapter userPersistenceAdapter, UserEventPublisherAdapter userEventPublisherAdapter) {
        return new UserService(userPersistenceAdapter, userEventPublisherAdapter);
    }

}
