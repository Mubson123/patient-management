package com.pm.authservice.service;

import com.pm.authservice.dto.LoginRequestDTO;
import com.pm.authservice.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final JwtUtil jwtUtil;
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
    return userService
        .findByEmail(loginRequestDTO.getEmail())
        .filter(
            someUser ->
                passwordEncoder.matches(loginRequestDTO.getPassword(), someUser.getPassword()))
        .map(user -> jwtUtil.generateToken(user.getEmail(), user.getRole()));
  }

  @Override
  public boolean validateToken(String token) {
      try{
          jwtUtil.validateToken(token);
          return true;
      } catch (JwtException e){
          return false;
      }
  }
}
