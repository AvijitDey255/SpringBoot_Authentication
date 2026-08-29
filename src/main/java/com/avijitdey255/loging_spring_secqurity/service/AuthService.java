package com.avijitdey255.loging_spring_secqurity.service;

import com.avijitdey255.loging_spring_secqurity.dto.UserRegisterDto;
import com.avijitdey255.loging_spring_secqurity.dto.UserRegisterResponseDto;
import com.avijitdey255.loging_spring_secqurity.entity.User;
import com.avijitdey255.loging_spring_secqurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository
//                       ,PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto register(UserRegisterDto registerRequestDto){
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());
        String encodedPass = passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassword(encodedPass);
        user.setEnabled(true);
        userRepository.save(user);

        UserRegisterResponseDto responseDto =new UserRegisterResponseDto();
        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User register successfully");
        return responseDto;
    }
}
