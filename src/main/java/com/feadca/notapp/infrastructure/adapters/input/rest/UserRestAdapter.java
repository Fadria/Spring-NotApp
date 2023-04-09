package com.feadca.notapp.infrastructure.adapters.input.rest;

import com.feadca.notapp.application.ports.input.CreateUserUseCase;
import com.feadca.notapp.application.ports.input.GetUserUseCase;
import com.feadca.notapp.domain.model.User;
import com.feadca.notapp.infrastructure.adapters.input.rest.data.request.UserCreateRequest;
import com.feadca.notapp.infrastructure.adapters.input.rest.data.response.UserCreateResponse;
import com.feadca.notapp.infrastructure.adapters.input.rest.data.response.UserQueryResponse;
import com.feadca.notapp.infrastructure.adapters.input.rest.mapper.UserRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserRestAdapter {

    private final CreateUserUseCase createUserUseCase;

    private final GetUserUseCase getUserUseCase;

    private final UserRestMapper userRestMapper;

    @PostMapping(value = "/users")
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest){
        // Request to domain
        User user = userRestMapper.toUser(userCreateRequest);

        user = createUserUseCase.createUser(user);

        // Domain to response
        return new ResponseEntity<>(userRestMapper.toUserCreateResponse(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserQueryResponse> getUser(@PathVariable Long id){
        User user = getUserUseCase.getUserById(id);
        return new ResponseEntity<>(userRestMapper.toUserQueryResponse(user), HttpStatus.OK);
    }

}
