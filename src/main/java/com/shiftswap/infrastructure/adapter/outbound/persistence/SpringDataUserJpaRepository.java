package com.shiftswap.infrastructure.adapter.outbound.persistence;

import com.shiftswap.domain.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataUserJpaRepository extends JpaRepository<UserProfile, UUID> {
    UserProfile getFirstByName(String name);
}
