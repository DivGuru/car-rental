package com.Leasing.lease.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Leasing.lease.Clients.CarClient;
import com.Leasing.lease.Clients.CarDTO;
import com.Leasing.lease.Entity.LeaseDTO;
import com.Leasing.lease.Entity.Status;
import com.Leasing.lease.Repository.LeaseDTORepository;

@Service
public class LeaseService {
	
	private final LeaseDTORepository leaseDTORepository;
	
	@Autowired
    private CarClient carClient;

	public LeaseService(LeaseDTORepository leaseDTORepository) {
		super();
		this.leaseDTORepository = leaseDTORepository;
	}
	
	public ResponseEntity<LeaseDTO> getLease(Long id) throws Exception{
		try {
			LeaseDTO lease= leaseDTORepository.findById(id).orElseThrow(()-> new RuntimeException("Lease Date Not Found"));
			return ResponseEntity.ok(lease);
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unused")
	public ResponseEntity<LeaseDTO> AddLease(LeaseDTO lease) throws Exception{
		try {
			
	        LocalDateTime now = LocalDateTime.now();
	        
	        if (lease.getLeaseStartDateTime().isAfter(now)) {
	            lease.setStatus(Status.NOTSTARTED);
	        } else if (lease.getLeaseEndDate().isBefore(now)) {
	            lease.setStatus(Status.CONCLUDED);
	        } else {
	            lease.setStatus(Status.STARTED);
	        }
	        
	        Long carId=lease.getCarId();
	        
	        CarDTO car = carClient.getCarById(carId);
	        System.out.println("Before");
	        String ans=carClient.UpdateAvailability(carId);
	        System.out.println(ans);
	        System.out.println("After");
	        System.out.printf("Car deails %d %s\n",car.getCarId(),car.getCarModel());
	        System.out.println(car);
	        double leaseAmount = calculateLeaseAmount(car);
	        System.out.printf("%f we got leaseamount as \n",leaseAmount);
	        // Set calculated lease amount
	        lease.setTotalAmount(leaseAmount);

	        // Set other lease details as needed
	        lease.setCarId(carId);
	        lease.setStatus(Status.STARTED);

	        // Save lease to database
	        LeaseDTO newlease=leaseDTORepository.save(lease);
	        System.out.println("And we get" + newlease);
	        System.out.print("In here we got id:");
	        System.out.print(newlease.getLeaseId());
	        return ResponseEntity.ok(newlease);
	    }
		catch(Exception e) {
			return null;
		}
	}

	    private double calculateLeaseAmount(CarDTO car) {
	        // Implement your lease calculation logic here
	        // For example, using car's gross price
	        double grossPrice = Double.parseDouble(car.getCarGrossPrice());
	        double interestRate = 0.05; // 5% interest rate
	        return grossPrice * interestRate;
	    }
	
	
	
	
}
