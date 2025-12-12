package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record SwapRequestDTO(
        String id,
        String requesterId,
        String requesterName,
        List<ShiftDetailDTO> requesterShifts,
        String targetId,
        String targetName,
        List<ShiftDetailDTO> targetShifts,
        String status,
        String createdAt,
        String message
) {
}
