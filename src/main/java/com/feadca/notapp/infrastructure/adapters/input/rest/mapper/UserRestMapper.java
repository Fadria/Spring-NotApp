package com.feadca.notapp.infrastructure.adapters.input.rest.mapper;

import com.feadca.notapp.domain.model.User;
import com.feadca.notapp.infrastructure.adapters.input.rest.data.request.UserCreateRequest;
import com.feadca.notapp.infrastructure.adapters.input.rest.data.response.UserCreateResponse;
import com.feadca.notapp.infrastructure.adapters.input.rest.data.response.UserQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserRestMapper {

    User toUser(UserCreateRequest userCreateRequest);

    UserCreateResponse toUserCreateResponse(User user);

    UserQueryResponse toUserQueryResponse(User user);

}
