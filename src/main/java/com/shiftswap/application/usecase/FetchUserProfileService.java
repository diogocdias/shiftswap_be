package com.shiftswap.application.usecase;

import com.shiftswap.application.mapper.UserProfileMapper;
import com.shiftswap.domain.port.inbound.GetUserProfileUseCase;
import com.shiftswap.domain.port.outbound.JpaPostgresRepositoryPort;
import com.shiftswap.infrastructure.adapter.inbound.graphql.model.UserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchUserProfileService implements GetUserProfileUseCase {
    JpaPostgresRepositoryPort jpaPostgresRepositoryPort;
    UserProfileMapper userProfileMapper;

    public FetchUserProfileService(@Autowired JpaPostgresRepositoryPort jpaPostgresRepositoryPort,
                                   @Autowired UserProfileMapper userProfileMapper) {
        this.jpaPostgresRepositoryPort = jpaPostgresRepositoryPort;
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public UserProfileDTO getUserProfile() {
        return userProfileMapper.toDTO(jpaPostgresRepositoryPort.fetchUserProfile());
    }
}
