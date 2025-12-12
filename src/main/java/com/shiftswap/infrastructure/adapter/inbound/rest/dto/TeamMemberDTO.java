package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record TeamMemberDTO(
        String id,
        String name,
        String role
) {
}
