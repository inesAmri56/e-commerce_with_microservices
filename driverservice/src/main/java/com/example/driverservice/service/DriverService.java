package com.example.driverservice.service;
import com.example.driverservice.dtos.request.DriverRequest;
import com.example.driverservice.dtos.response.DriverResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface DriverService {
    DriverResponse createDriver(DriverRequest driverRequest);
    DriverResponse getDriver(Long id);
    List<DriverResponse> getAllDrivers();
    DriverResponse updateDriver(DriverRequest driverRequest,Long id);
    HashMap<String , String >deleteDriver(Long id);
}
