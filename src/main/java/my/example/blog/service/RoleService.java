package my.example.blog.service;

import my.example.blog.domain.Role;
import my.example.blog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public void addRole(Role role) {
        Role result = roleRepository.save(role);
        System.out.println(result.getId() + ", " + result.getName());
    }
}