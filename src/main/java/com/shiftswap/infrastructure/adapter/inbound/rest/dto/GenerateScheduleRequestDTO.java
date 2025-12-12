package com.shiftswap.infrastructure.adapter.inbound.rest.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record GenerateScheduleRequestDTO(
        String startDate,
        String endDate,
        List<TeamMemberDTO> teamMembers
) {
}
