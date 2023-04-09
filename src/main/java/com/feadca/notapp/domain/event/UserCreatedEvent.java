package com.feadca.notapp.domain.event;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public UserCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

}

