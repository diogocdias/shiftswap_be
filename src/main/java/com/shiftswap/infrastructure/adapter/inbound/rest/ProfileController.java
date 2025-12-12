package com.shiftswap.infrastructure.adapter.inbound.rest;

import com.shiftswap.infrastructure.adapter.inbound.rest.dto.SuccessResponseDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.UserProfileResponseDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.UserProfileUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileResponseDTO> getUserProfile(@PathVariable String userId) {
        return ResponseEntity.ok(UserProfileResponseDTO.builder()
                .name("John Doe")
                .email("user@hospital.com")
                .phone("+1 (555) 123-4567")
                .role("user")
                .department("Emergency")
                .employeeId("EMP-001")
                .facility("Central Hospital")
                .startDate("2022-03-15")
                .profilePicture(null)
                .language("en")
                .build());
    }

    @PutMapping
    public ResponseEntity<SuccessResponseDTO> updateProfile(@RequestBody UserProfileUpdateDTO profile) {
        return ResponseEntity.ok(SuccessResponseDTO.builder()
                .success(true)
                .build());
    }
}
