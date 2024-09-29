package com.lease.customer.dto;

import java.time.LocalDateTime;

public class LeaseDTO {
    private Long leaseId;

    private Long userId;

    private Long carId;

    private double totalAmount;

    private LocalDateTime leaseStartDateTime;

    private LocalDateTime leaseEndDate;

    private Double leaseInterestRate;

    private Status status;
}
