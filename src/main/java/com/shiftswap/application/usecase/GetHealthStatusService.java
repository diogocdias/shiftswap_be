package com.shiftswap.application.usecase;

import com.shiftswap.domain.entity.HealthStatus;
import com.shiftswap.domain.port.input.GetHealthStatusUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetHealthStatusService implements GetHealthStatusUseCase {

    private final String applicationVersion;

    public GetHealthStatusService(
            @Value("${application.version:0.0.1-SNAPSHOT}") String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    @Override
    public HealthStatus getHealthStatus() {
        return HealthStatus.healthy(applicationVersion);
    }
}
