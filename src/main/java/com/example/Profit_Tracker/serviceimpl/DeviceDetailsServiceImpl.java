package com.example.Profit_Tracker.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.Profit_Tracker.entity.DeviceDetails;
import com.example.Profit_Tracker.repository.DeviceDetailsRepository;
import com.example.Profit_Tracker.services.DeviceDetailsService;

@Service
public class DeviceDetailsServiceImpl implements DeviceDetailsService {

    private final DeviceDetailsRepository repository;

    public DeviceDetailsServiceImpl(DeviceDetailsRepository repository) {
     this.repository = repository;
    }

    @Override
    public DeviceDetails save(DeviceDetails device) {
        return repository.save(device);
    }

    @Override
    public List<DeviceDetails> getAll() {
        return repository.findAll();
    }

    @Override
    public DeviceDetails getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Device not found"));
    }

    @Override
    public DeviceDetails update(
            UUID id,
            DeviceDetails device) {

        DeviceDetails existing = getById(id);

        existing.setDeviceDate(device.getDeviceDate());
        existing.setBrand(device.getBrand());
        existing.setModel(device.getModel());
        existing.setSerialNumber(device.getSerialNumber());
        existing.setMacAddress(device.getMacAddress());
        existing.setDeviceId(device.getDeviceId());
        existing.setPower(device.getPower());

        return repository.save(existing);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public DeviceDetails getBySerialNumber(String serialNumber) {

        return repository.findBySerialNumber(serialNumber)
                .orElseThrow(() ->
                        new RuntimeException("Device not found with serial number: "
                                + serialNumber));
    }
}