package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record UserProfileUpdateDTO(
        String name,
        String email,
        String phone,
        String department,
        String facility,
        String profilePicture,
        String language
) {
}
