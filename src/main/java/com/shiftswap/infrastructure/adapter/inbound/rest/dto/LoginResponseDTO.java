package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record LoginResponseDTO(
        String name,
        String email,
        String role,
        String sessionId
) {
}
