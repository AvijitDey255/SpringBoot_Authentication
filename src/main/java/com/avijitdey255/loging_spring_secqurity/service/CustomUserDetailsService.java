package com.avijitdey255.loging_spring_secqurity.service;

import com.avijitdey255.loging_spring_secqurity.entity.CustomUserDetails;
import com.avijitdey255.loging_spring_secqurity.entity.User;
import com.avijitdey255.loging_spring_secqurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found"));

       return new CustomUserDetails(user);
    }
}
