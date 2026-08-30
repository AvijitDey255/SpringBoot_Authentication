package com.avijitdey255.loging_spring_secqurity.service;


import com.avijitdey255.loging_spring_secqurity.entity.Role;
import com.avijitdey255.loging_spring_secqurity.repository.RoleRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    public void addRole(Role role){
        roleRepository.save(role);
    }
}
