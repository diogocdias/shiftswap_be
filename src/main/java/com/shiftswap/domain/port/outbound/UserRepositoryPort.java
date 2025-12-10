package com.shiftswap.domain.port.outbound;

import com.shiftswap.domain.entity.UserProfile;

public interface UserRepositoryPort {
    UserProfile fetchUserProfile(String username);
}
