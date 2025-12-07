package com.shiftswap.application.mapper;

public interface Mapper<K,V> {
    V toDTO(K k);
    K toEntity(V v);
}
