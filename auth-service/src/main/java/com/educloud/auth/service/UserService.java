package com.educloud.auth.service;

import com.educloud.auth.dto.UserResponse;
import com.educloud.auth.entity.User;
import com.educloud.auth.exception.AuthException;
import com.educloud.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserResponse getUserProfile(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthException("User not found", "AUTH_002"));
        
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .universityId(user.getUniversityId())
                .active(user.isActive())
                .createdAt(user.getCreatedAt())
                .build();
    }
    
    public UserResponse getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AuthException("User not found", "AUTH_002"));
        
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .universityId(user.getUniversityId())
                .active(user.isActive())
                .createdAt(user.getCreatedAt())
                .build();
    }
}