package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

@Builder
public record ShiftDetailDTO(
        String date,
        String shiftType,
        String timeDisplay
) {
}
