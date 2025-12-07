package com.shiftswap.infrastructure.adapter.outbound.persistence;

import com.shiftswap.domain.entity.UserProfile;
import com.shiftswap.domain.port.outbound.JpaPostgresRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class JpaPostgresRepositoryPortImpl implements JpaPostgresRepositoryPort {
    @Override
    public UserProfile fetchUserProfile() {
        return UserProfile.builder()
                .name("username")
                .role("user")
                .build();
    }
}
