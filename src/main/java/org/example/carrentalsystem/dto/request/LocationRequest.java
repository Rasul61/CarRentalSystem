package org.example.carrentalsystem.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class LocationRequest {
    String name;
    String city;
    String address;
}
