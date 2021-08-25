package com.example.springrestanime.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }

    public Role(Map<String, Object> map) {
        this.id = Long.valueOf((Integer) map.get("id"));
        this.name = (String) map.get("name");
    }
}
