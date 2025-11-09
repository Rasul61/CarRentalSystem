package org.example.carrentalsystem.service.concurate;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dao.entity.Location;
import org.example.carrentalsystem.dao.repository.LocationRepository;
import org.example.carrentalsystem.dto.request.LocationRequest;
import org.example.carrentalsystem.dto.response.LocationResponse;
import org.example.carrentalsystem.exceptions.NotFoundException;
import org.example.carrentalsystem.mapper.LocationMapper;
import org.example.carrentalsystem.service.abstraction.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.carrentalsystem.mapper.LocationMapper.entityToResponse;
import static org.example.carrentalsystem.mapper.LocationMapper.requestToEntity;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public LocationResponse createLocation(LocationRequest locationRequest) {
        Location location = locationRepository.save(requestToEntity(locationRequest));
        return entityToResponse(location);
    }

    @Override
    public List<LocationResponse> getAllLocations() {
        return locationRepository.findAll().
                stream().
                map(LocationMapper::entityToResponse).
                toList();
    }

    @Override
    public LocationResponse getById(Long id) {
        Location location = locationRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found location with this id : " + id));
        return entityToResponse(location);
    }

    @Override
    public LocationResponse getLocationByName(String name) {
        Location location = locationRepository.findByName(name);
        return entityToResponse(location);
    }

    @Override
    public LocationResponse getLocationByCity(String city) {
        Location location = locationRepository.findByCity(city);
        return entityToResponse(location);
    }

    @Override
    public LocationResponse getLocationByAddress(String address) {
        Location location = locationRepository.findByAddress(address);
        return entityToResponse(location);
    }

    @Override
    public LocationResponse updateLocation(Long id, LocationRequest locationRequest) {
        Location location = locationRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found location with this id : " + id));
        if (locationRequest.getName() != null && locationRequest.getName().isBlank()) {
            location.setName(locationRequest.getName());
        }
        if (locationRequest.getCity() != null && locationRequest.getCity().isBlank()) {
            location.setCity(locationRequest.getCity());
        }
        if (locationRequest.getAddress() != null && locationRequest.getAddress().isBlank()) {
            location.setAddress(locationRequest.getAddress());
        }
        locationRepository.save(location);

        return entityToResponse(location);
    }

    @Override
    public void deleteLocationById(Long id) {
        locationRepository.deleteById(id);

    }
}
