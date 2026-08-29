package com.avijitdey255.loging_spring_secqurity.controller;

import com.avijitdey255.loging_spring_secqurity.dto.UserRegisterDto;
import com.avijitdey255.loging_spring_secqurity.dto.UserRegisterResponseDto;
import com.avijitdey255.loging_spring_secqurity.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterDto registerRequestDto){
        UserRegisterResponseDto userRegisterResponseDto = authService.register(registerRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);

    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
