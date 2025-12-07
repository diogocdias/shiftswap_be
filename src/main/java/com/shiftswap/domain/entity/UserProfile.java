package com.shiftswap.domain.entity;


//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//@Entity
//@Table(name = "user_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    //@Id
    //@Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    //@Column(name = "name", nullable = false)
    private String name;

    //@Column(name = "role", nullable = false)
    private String role;
}

