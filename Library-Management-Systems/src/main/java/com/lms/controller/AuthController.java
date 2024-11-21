package com.lms.controller;

import com.lms.dao.UserDao;
import com.lms.dto.AuthenticationRequest;
import com.lms.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        final UserDetails user = userDao.findUserByEmail(request.getEmail());
        if (user != null){
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }


}
