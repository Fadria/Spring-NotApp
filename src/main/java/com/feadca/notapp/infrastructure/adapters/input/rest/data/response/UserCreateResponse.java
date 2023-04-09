package com.feadca.notapp.infrastructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponse {

    private Long id;

    private String username;

    private String fullname;

    private String email;

    private String role;

    private String avatar;

}
