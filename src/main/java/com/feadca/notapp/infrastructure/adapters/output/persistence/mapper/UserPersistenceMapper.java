package com.feadca.notapp.infrastructure.adapters.output.persistence.mapper;

import com.feadca.notapp.domain.model.User;
import com.feadca.notapp.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserPersistenceMapper {

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);
}
