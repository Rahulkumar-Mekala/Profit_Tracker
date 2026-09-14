package com.example.Profit_Tracker.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Profit_Tracker.entity.DeviceDetails;

import java.util.Optional;
import java.util.UUID;

public interface DeviceDetailsRepository extends JpaRepository<DeviceDetails, UUID> {
	  Optional<DeviceDetails> findBySerialNumber(String serialNumber);
	  boolean existsBySerialNumber(String serialNumber);
}