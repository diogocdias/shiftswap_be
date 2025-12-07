package com.shiftswap.domain.port.input;

import com.shiftswap.domain.entity.HealthStatus;

public interface GetHealthStatusUseCase {
    HealthStatus getHealthStatus();
}
