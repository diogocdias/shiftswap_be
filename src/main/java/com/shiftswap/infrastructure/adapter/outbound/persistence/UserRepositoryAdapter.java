package com.shiftswap.infrastructure.adapter.outbound.persistence;

import com.shiftswap.domain.entity.UserProfile;
import com.shiftswap.domain.port.outbound.UserRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataUserJpaRepository jpaUserRepository;

    public UserRepositoryAdapter(SpringDataUserJpaRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public UserProfile fetchUserProfile(String username) {
        return jpaUserRepository.getFirstByName(username);
    }
}
