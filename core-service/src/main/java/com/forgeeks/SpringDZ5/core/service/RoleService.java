package com.forgeeks.SpringDZ5.core.service;

import com.forgeeks.SpringDZ5.core.entities.Role;
import com.forgeeks.SpringDZ5.core.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
