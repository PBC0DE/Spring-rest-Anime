package com.example.springrestanime.entities;

import com.example.springrestanime.dtos.UserDTO;
import com.example.springrestanime.dtos.requests.RegisterRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @CreationTimestamp
    @Column(name = "created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    public User(RegisterRequest registerRequest) {
        this.username = registerRequest.getUsername();
        this.password = registerRequest.getPassword();
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.username = userDTO.getUsername();
        this.roles = userDTO.getRoles();
        this.created = LocalDateTime.parse(userDTO.getCreated());
        this.updated = LocalDateTime.parse(userDTO.getUpdated());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin() {
        for (Role role : roles) {
            if (role.getName().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

}
