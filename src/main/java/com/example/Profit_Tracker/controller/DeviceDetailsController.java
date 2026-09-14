package com.example.Profit_Tracker.controller;



import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profit_Tracker.entity.DeviceDetails;
import com.example.Profit_Tracker.services.DeviceDetailsService;

@RestController
@RequestMapping("/api/devices")
public class DeviceDetailsController {

    private final DeviceDetailsService service;

    public DeviceDetailsController( DeviceDetailsService service) {

        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody DeviceDetails device) {

        try {

            if (device.getDeviceDate() == null) {
                return ResponseEntity
                        .badRequest()
                        .body("Device date is required");
            }

            if (device.getSerialNumber() == null ||
                    device.getSerialNumber().isBlank()) {

                return ResponseEntity
                        .badRequest()
                        .body("Serial number is required");
            }

            return ResponseEntity.ok(service.save(device));

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body("Failed to save device: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<DeviceDetails>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDetails> getById( @PathVariable UUID id) {

        return ResponseEntity.ok(service.getById(id));
    }
   
    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<DeviceDetails> getBySerialNumber(
            @PathVariable String serialNumber) {

        return ResponseEntity.ok(
                service.getBySerialNumber(serialNumber)
        );
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DeviceDetails> update(
            @PathVariable UUID id,
            @RequestBody DeviceDetails device) {

        return ResponseEntity.ok(
                service.update(id, device)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
    
  
}
