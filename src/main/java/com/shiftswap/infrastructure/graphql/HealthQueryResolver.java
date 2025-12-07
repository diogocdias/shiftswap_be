package com.shiftswap.infrastructure.graphql;

import com.shiftswap.domain.entity.HealthStatus;
import com.shiftswap.domain.port.input.GetHealthStatusUseCase;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HealthQueryResolver {

    private final GetHealthStatusUseCase getHealthStatusUseCase;

    public HealthQueryResolver(GetHealthStatusUseCase getHealthStatusUseCase) {
        this.getHealthStatusUseCase = getHealthStatusUseCase;
    }

    @QueryMapping
    public HealthStatus health() {
        return getHealthStatusUseCase.getHealthStatus();
    }
}
