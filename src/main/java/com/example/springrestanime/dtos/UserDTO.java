package com.example.springrestanime.dtos;

import com.example.springrestanime.entities.Role;
import com.example.springrestanime.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private Set<Role> roles;

    private String created;

    private String updated;


    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles();
        this.created = user.getCreated().toString();
        this.updated = user.getUpdated().toString();
    }
}
