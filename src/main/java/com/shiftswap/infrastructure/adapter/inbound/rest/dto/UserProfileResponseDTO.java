package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record UserProfileResponseDTO(
        String name,
        String email,
        String phone,
        String role,
        String department,
        String employeeId,
        String facility,
        String startDate,
        String profilePicture,
        String language
) {
}
