package com.example.auth.service;

import com.example.auth.model.AuthResponse;
import com.example.auth.dto.UserDto;
import com.example.auth.dto.UserRegistrationRequest;
import com.example.auth.client.UserManagementClient;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    private final UserManagementClient userManagementClient;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.accessTokenExpirationMs}")
    private long accessTokenExpirationMs;

    @Value("${jwt.refreshTokenExpirationMs}")
    private long refreshTokenExpirationMs;

    public AuthService(UserManagementClient userManagementClient, PasswordEncoder passwordEncoder) {
        this.userManagementClient = userManagementClient;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse login(String email, String password) {
        UserDto userDto;
        try {
            userDto = userManagementClient.getUserByEmail(email);
        } catch (Exception ex) {
            return new AuthResponse(null, null, "User not found");
        }
        if (userDto == null) {
            return new AuthResponse(null, null, "User not found");
        }
        if (!passwordEncoder.matches(password, userDto.getPassword())) {
            return new AuthResponse(null, null, "Invalid credentials");
        }
        String accessToken = generateToken(email, accessTokenExpirationMs);
        String refreshToken = generateToken(email, refreshTokenExpirationMs);
        return new AuthResponse(accessToken, refreshToken, "Login successful");
    }

    public AuthResponse register(String email, String password, String name) {
        try {
            UserDto existingUser = userManagementClient.getUserByEmail(email);
            if (existingUser != null) {
                return new AuthResponse(null, null, "User already exists");
            }
        } catch (Exception ex) {
            // Если сервис вернул ошибку (например, 404), продолжаем регистрацию
        }
        String hashedPassword = passwordEncoder.encode(password);
        UserRegistrationRequest request = new UserRegistrationRequest(email, name, hashedPassword);
        UserDto createdUser = userManagementClient.createUser(request);
        if (createdUser == null) {
            return new AuthResponse(null, null, "Registration failed");
        }
        String accessToken = generateToken(email, accessTokenExpirationMs);
        String refreshToken = generateToken(email, refreshTokenExpirationMs);
        return new AuthResponse(accessToken, refreshToken, "Registration successful");
    }

    public AuthResponse refreshAccessToken(String refreshToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret.getBytes())
                    .parseClaimsJws(refreshToken)
                    .getBody();
            String subject = claims.getSubject();
            String newAccessToken = generateToken(subject, accessTokenExpirationMs);
            return new AuthResponse(newAccessToken, refreshToken, "Token refreshed successfully");
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException |
                 SignatureException | IllegalArgumentException ex) {
            return new AuthResponse(null, null, "Invalid refresh token");
        }
    }

    private String generateToken(String subject, long expirationMs) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();
    }
}
