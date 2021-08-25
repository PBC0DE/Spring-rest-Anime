package com.example.springrestanime.services;

import com.example.springrestanime.entities.User;
import com.example.springrestanime.exceptions.ResourceNotFoundException;
import com.example.springrestanime.exceptions.UserAlreadyExistsException;
import com.example.springrestanime.exceptions.UserNotFoundException;
import com.example.springrestanime.repositories.RoleRepository;
import com.example.springrestanime.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User createUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException(user.getUsername());
        }

        user.setRoles(Set.of(roleRepository.getRoleByName("USER").get()));
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(getUser(id).getId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }
}
