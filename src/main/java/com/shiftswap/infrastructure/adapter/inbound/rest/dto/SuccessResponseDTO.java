package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record SuccessResponseDTO(
        boolean success
) {
}
