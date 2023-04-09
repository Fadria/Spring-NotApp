package com.feadca.notapp.infrastructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryResponse {

    private Long id;

    private String username;

    private String fullname;

    private String email;

    private String role;

    private String avatar;

}
