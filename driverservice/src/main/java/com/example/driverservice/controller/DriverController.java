package com.example.driverservice.controller;
import com.example.driverservice.dtos.request.DriverRequest;
import com.example.driverservice.dtos.response.DriverResponse;
import com.example.driverservice.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/driverapi")
public class DriverController {
    public static DriverService driverService;
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }
    @PostMapping("/createDriver")
    public DriverResponse createDriver(@RequestBody DriverRequest driverRequest){
        return driverService.createDriver(driverRequest);
    }
    @GetMapping("/getAllDrivers")
    public List<DriverResponse> getAllDrivers(){
        return driverService.getAllDrivers();
    }
    @GetMapping("/getDriverById/{id}")
    public DriverResponse getDrriverById(@PathVariable Long id){

        return driverService.getDriver(id);
    }
    @PutMapping("/updateDriver/{id}")
    public DriverResponse updateDriver(@PathVariable Long id, @RequestBody DriverRequest driverRequest) {
        return driverService.updateDriver(driverRequest, id);
    }

    @DeleteMapping("/deleteDriver/{id}")
    public HashMap<String, String> deleteDriverById(@PathVariable Long id) {
        return driverService.deleteDriver(id);
    }}
