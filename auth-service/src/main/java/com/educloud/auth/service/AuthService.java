package com.educloud.auth.service;

import com.educloud.auth.config.JwtService;
import com.educloud.auth.dto.AuthResponse;
import com.educloud.auth.dto.LoginRequest;
import com.educloud.auth.dto.RegisterRequest;
import com.educloud.auth.entity.Role;
import com.educloud.auth.entity.User;
import com.educloud.auth.exception.AuthException;
import com.educloud.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AuthException("Email already exists", "AUTH_001");
        }
        
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(request.getRole() != null ? request.getRole() : Role.STUDENT)
                .universityId(request.getUniversityId())
                .active(true)
                .build();
        
        User savedUser = userRepository.save(user);
        
        String jwtToken = jwtService.generateToken(savedUser);
        
        return AuthResponse.builder()
                .token(jwtToken)
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .role(savedUser.getRole())
                .universityId(savedUser.getUniversityId())
                .expiresIn(86400000L) 
                .build();
    }
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AuthException("User not found", "AUTH_002"));
        
        if (!user.isActive()) {
            throw new AuthException("User account is disabled", "AUTH_003");
        }
        
        String jwtToken = jwtService.generateToken(user);
        
        return AuthResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .universityId(user.getUniversityId())
                .expiresIn(86400000L)
                .build();
    }
    
    public void logout(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new AuthException("Invalid token", "AUTH_004");
        }
    }
}