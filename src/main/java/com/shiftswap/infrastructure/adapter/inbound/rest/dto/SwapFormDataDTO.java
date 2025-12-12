package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record SwapFormDataDTO(
        String targetUserId,
        List<ShiftDetailDTO> targetShifts,
        List<ShiftDetailDTO> myShifts,
        String message
) {
}
