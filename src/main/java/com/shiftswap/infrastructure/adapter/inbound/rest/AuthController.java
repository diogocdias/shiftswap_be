package com.shiftswap.infrastructure.adapter.inbound.rest;

import com.shiftswap.infrastructure.adapter.inbound.rest.dto.LoginRequestDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.LoginResponseDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.SuccessResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Map<String, MockUser> MOCK_USERS = Map.of(
            "user@hospital.com", new MockUser("user@hospital.com", "password", "John Doe", "user"),
            "leader@hospital.com", new MockUser("leader@hospital.com", "password", "Jane Smith", "teamleader"),
            "admin@hospital.com", new MockUser("admin@hospital.com", "password", "Admin User", "admin")
    );

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        MockUser user = MOCK_USERS.get(request.email());

        if (user == null || !user.password().equals(request.password())) {
            return ResponseEntity.status(401).build();
        }

        String sessionId = UUID.randomUUID().toString();

        return ResponseEntity.ok(LoginResponseDTO.builder()
                .name(user.name())
                .email(user.email())
                .role(user.role())
                .sessionId(sessionId)
                .build());
    }

    @PostMapping("/logout")
    public ResponseEntity<SuccessResponseDTO> logout(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        return ResponseEntity.ok(SuccessResponseDTO.builder()
                .success(true)
                .build());
    }

    @GetMapping("/session")
    public ResponseEntity<SuccessResponseDTO> validateSession(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        boolean isValid = authHeader != null && authHeader.startsWith("Bearer ");
        return ResponseEntity.ok(SuccessResponseDTO.builder()
                .success(isValid)
                .build());
    }

    private record MockUser(String email, String password, String name, String role) {
    }
}
