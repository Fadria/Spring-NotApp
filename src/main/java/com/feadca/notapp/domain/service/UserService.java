package com.feadca.notapp.domain.service;

import com.feadca.notapp.application.ports.input.CreateUserUseCase;
import com.feadca.notapp.application.ports.input.GetUserUseCase;
import com.feadca.notapp.application.ports.output.UserEventPublisher;
import com.feadca.notapp.application.ports.output.UserOutputPort;
import com.feadca.notapp.domain.event.UserCreatedEvent;
import com.feadca.notapp.domain.exception.UserNotFound;
import com.feadca.notapp.domain.model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService implements CreateUserUseCase, GetUserUseCase {

    private final UserOutputPort userOutputPort;

    private final UserEventPublisher userEventPublisher;

    @Override
    public User createUser(User user) {
        user = userOutputPort.saveUser(user);
        userEventPublisher.publishUserCreatedEvent(new UserCreatedEvent(user.getId()));
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userOutputPort.getUserById(id).orElseThrow(() -> new UserNotFound("User not found with id " + id));
    }

}
