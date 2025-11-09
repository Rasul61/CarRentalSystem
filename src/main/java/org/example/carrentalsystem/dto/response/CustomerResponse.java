package org.example.carrentalsystem.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CustomerResponse {
    Long id;
    String fullName;
    String email;
    String phone;
}
