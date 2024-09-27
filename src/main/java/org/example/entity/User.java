package org.example.entity;

import lombok.*;
import org.example.enums.State;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long chatId;
    private String name;
    private String phoneNumber;
    private State state;

    public User(Long id){
        this.chatId=id;
    }



}
