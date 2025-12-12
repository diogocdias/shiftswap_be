package com.shiftswap.domain.port.inbound;


import com.shiftswap.infrastructure.adapter.inbound.rest.dto.UserProfileResponseDTO;

public interface GetUserProfileUseCase {
    UserProfileResponseDTO getUserProfile(String username);
}
