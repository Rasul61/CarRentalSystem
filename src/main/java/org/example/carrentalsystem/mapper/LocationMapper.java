package org.example.carrentalsystem.mapper;

import org.example.carrentalsystem.dao.entity.Location;
import org.example.carrentalsystem.dto.request.LocationRequest;
import org.example.carrentalsystem.dto.response.LocationResponse;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public static Location requestToEntity(LocationRequest locationRequest) {
        return Location.builder().
                name(locationRequest.getName()).
                city(locationRequest.getCity()).
                address(locationRequest.getAddress()).
                build();

    }

    public static LocationResponse entityToResponse(Location location) {
        return LocationResponse.builder().
                id(location.getId()).
                name(location.getName()).
                city(location.getCity()).
                address(location.getAddress()).
                build();
    }
}
