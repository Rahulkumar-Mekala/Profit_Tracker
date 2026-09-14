package com.example.Profit_Tracker.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "device_details")
@Data
public class DeviceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate deviceDate;

    private String brand;
    private String model;
    private String productTypes;
    @Column(nullable = false, unique = true)
    private String serialNumber;

    private String macAddress;

    private String deviceId;

    private String power;
}