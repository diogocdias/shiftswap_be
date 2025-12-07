package com.shiftswap.application.mapper;

import com.shiftswap.domain.entity.UserProfile;
import com.shiftswap.infrastructure.adapter.inbound.graphql.model.UserProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper implements Mapper<UserProfile, UserProfileDTO> {
    @Override
    public UserProfileDTO toDTO(UserProfile userProfile) {
        return UserProfileDTO.builder()
                .name(userProfile.getName())
                .role(userProfile.getRole())
                .build();
    }

    @Override
    public UserProfile toEntity(UserProfileDTO userProfileDTO) {
        return UserProfile.builder()
                .name(userProfileDTO.name())
                .role(userProfileDTO.role())
                .build();
    }
}
