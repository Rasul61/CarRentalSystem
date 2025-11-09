package org.example.carrentalsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.carrentalsystem.dto.request.LocationRequest;
import org.example.carrentalsystem.dto.response.LocationResponse;
import org.example.carrentalsystem.service.abstraction.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    LocationResponse createLocation(@RequestBody LocationRequest locationRequest) {
        return locationService.createLocation(locationRequest);
    }

    @GetMapping
    List<LocationResponse> findAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/id/{id}")
    LocationResponse findById(@PathVariable Long id) {
        return locationService.getById(id);
    }

    @GetMapping("/name/{name}")
    LocationResponse findByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping("/city/{city}")
    LocationResponse findByCity(@PathVariable String city) {
        return locationService.getLocationByCity(city);
    }

    @GetMapping("/address/{address}")
    LocationResponse findByAddress(@PathVariable String address) {
        return locationService.getLocationByAddress(address);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    LocationResponse updateLocation(@PathVariable Long id, @RequestBody LocationRequest locationRequest) {
        return locationService.updateLocation(id, locationRequest);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocationById(id);
    }
}
