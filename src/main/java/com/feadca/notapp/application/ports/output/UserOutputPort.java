package com.feadca.notapp.application.ports.output;

import com.feadca.notapp.domain.model.User;

import java.util.Optional;

public interface UserOutputPort {

    User saveUser(User user);

    Optional<User> getUserById(Long id);

}
