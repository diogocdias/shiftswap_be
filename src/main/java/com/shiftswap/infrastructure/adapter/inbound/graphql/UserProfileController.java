package com.shiftswap.infrastructure.adapter.inbound.graphql;

import com.shiftswap.domain.port.inbound.GetUserProfileUseCase;
import com.shiftswap.infrastructure.adapter.inbound.graphql.model.UserProfileDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserProfileController {

    private final GetUserProfileUseCase getUserProfileUseCase;

    public UserProfileController(GetUserProfileUseCase getUserProfileUseCase) {
        this.getUserProfileUseCase = getUserProfileUseCase;
    }

    @QueryMapping
    public UserProfileDTO profile(@Argument String username) {
        return getUserProfileUseCase.getUserProfile(username);
    }
}
