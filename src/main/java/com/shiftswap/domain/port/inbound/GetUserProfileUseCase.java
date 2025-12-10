package com.shiftswap.domain.port.inbound;


import com.shiftswap.infrastructure.adapter.inbound.graphql.model.UserProfileDTO;

public interface GetUserProfileUseCase {
    UserProfileDTO getUserProfile(String username);
}
