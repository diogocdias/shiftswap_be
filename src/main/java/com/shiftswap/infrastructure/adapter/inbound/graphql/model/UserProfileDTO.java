package com.shiftswap.infrastructure.adapter.inbound.graphql.model;

import lombok.Builder;

@Builder
public record UserProfileDTO(
        String name,
        String role
) {
}
