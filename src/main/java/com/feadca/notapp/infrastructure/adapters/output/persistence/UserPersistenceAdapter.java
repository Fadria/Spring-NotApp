package com.feadca.notapp.infrastructure.adapters.output.persistence;

import com.feadca.notapp.application.ports.output.UserOutputPort;
import com.feadca.notapp.domain.model.User;
import com.feadca.notapp.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.feadca.notapp.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import com.feadca.notapp.infrastructure.adapters.output.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutputPort {

    private final UserRepository userRepository;

    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userPersistenceMapper.toUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return userPersistenceMapper.toUser(userEntity);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);

        if(userEntity.isEmpty()) {
            return Optional.empty();
        }

        User user = userPersistenceMapper.toUser(userEntity.get());
        return Optional.of(user);
    }

}
