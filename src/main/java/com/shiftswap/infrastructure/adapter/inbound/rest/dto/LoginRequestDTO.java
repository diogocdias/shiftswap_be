package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record LoginRequestDTO(
        String email,
        String password
) {
}
