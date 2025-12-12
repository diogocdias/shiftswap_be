package com.shiftswap.application.mapper;

import com.shiftswap.domain.entity.UserProfile;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.UserProfileResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper implements Mapper<UserProfile, UserProfileResponseDTO> {
    @Override
    public UserProfileResponseDTO toDTO(UserProfile userProfile) {
        return UserProfileResponseDTO.builder()
                .name(userProfile.getName())
                .role(userProfile.getRole())
                .build();
    }

    @Override
    public UserProfile toEntity(UserProfileResponseDTO userProfileDTO) {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}
