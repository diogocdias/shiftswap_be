package com.shiftswap.domain.entity;

public record HealthStatus(
        String status,
        String version,
        long timestamp
) {
    public static HealthStatus healthy(String version) {
        return new HealthStatus("UP", version, System.currentTimeMillis());
    }
}
