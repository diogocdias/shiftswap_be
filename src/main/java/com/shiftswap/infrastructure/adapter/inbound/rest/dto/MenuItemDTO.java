package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record MenuItemDTO(
        String id,
        String label,
        String icon,
        Integer badge,
        Integer order
) {
}
