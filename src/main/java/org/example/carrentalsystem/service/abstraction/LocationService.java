package org.example.carrentalsystem.service.abstraction;

import org.example.carrentalsystem.dto.request.LocationRequest;
import org.example.carrentalsystem.dto.response.LocationResponse;

import java.util.List;

public interface LocationService {
    LocationResponse createLocation(LocationRequest locationRequest);
    List<LocationResponse> getAllLocations();
    LocationResponse getById(Long id);
    LocationResponse getLocationByName(String name);
    LocationResponse getLocationByCity(String city);
    LocationResponse getLocationByAddress(String address);
    LocationResponse updateLocation(Long id,LocationRequest locationRequest);
    void deleteLocationById(Long id);
}
