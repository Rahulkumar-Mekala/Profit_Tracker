package com.example.Profit_Tracker.services;

import java.util.List;
import java.util.UUID;

import com.example.Profit_Tracker.entity.DeviceDetails;

public interface DeviceDetailsService {

    DeviceDetails save(DeviceDetails device);

    List<DeviceDetails> getAll();

    DeviceDetails getById(UUID id);
    DeviceDetails getBySerialNumber(String serialNumber);
    DeviceDetails update(UUID id, DeviceDetails device);
   
    void delete(UUID id);
}