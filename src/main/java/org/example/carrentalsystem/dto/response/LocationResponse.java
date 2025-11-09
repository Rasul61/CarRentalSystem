package org.example.carrentalsystem.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class LocationResponse {
    Long id;
    String name;
    String city;
    String address;
}
