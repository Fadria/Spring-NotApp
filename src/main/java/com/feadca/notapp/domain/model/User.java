package com.feadca.notapp.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private String fullname;

    private String email;

    private String password;

    private String role;

    private String avatar;

}
