package com.feadca.notapp.application.ports.input;


import com.feadca.notapp.domain.model.User;

public interface CreateUserUseCase {

    User createUser(User user);

}
