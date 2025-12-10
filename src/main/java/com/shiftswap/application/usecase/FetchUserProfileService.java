package com.shiftswap.application.usecase;

import com.shiftswap.application.mapper.UserProfileMapper;
import com.shiftswap.domain.port.inbound.GetUserProfileUseCase;
import com.shiftswap.domain.port.outbound.UserRepositoryPort;
import com.shiftswap.infrastructure.adapter.inbound.graphql.model.UserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchUserProfileService implements GetUserProfileUseCase {
    UserRepositoryPort userRepositoryPort;
    UserProfileMapper userProfileMapper;

    public FetchUserProfileService(@Autowired UserRepositoryPort userRepositoryPort,
                                   @Autowired UserProfileMapper userProfileMapper) {
        this.userRepositoryPort = userRepositoryPort;
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public UserProfileDTO getUserProfile(String username) {
        return userProfileMapper.toDTO(userRepositoryPort.fetchUserProfile(username));
    }
}
