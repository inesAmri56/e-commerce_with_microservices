package com.example.driverservice.service.serviceImp;
import com.example.driverservice.dtos.request.DriverRequest;
import com.example.driverservice.dtos.response.DriverResponse;
import com.example.driverservice.model.Driver;
import com.example.driverservice.repository.DriverDAO;
import com.example.driverservice.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DriverServiceImp implements DriverService {
    public static DriverDAO driverdao;
    public DriverServiceImp(DriverDAO driverdao){
        this.driverdao=driverdao;
    }
    @Override
    public DriverResponse createDriver(DriverRequest driverRequest) {
        Driver driver = DriverResponse.toEntity(driverRequest);
        Driver saveDriver=driverdao.save(driver);
        return DriverResponse.fromEntity(saveDriver);
    }

    @Override
    public DriverResponse getDriver(Long id) {
        return driverdao.findById(id).map(DriverResponse::fromEntity).
                orElseThrow(()->new RuntimeException("Driver not fount"));
    }

    @Override
    public List<DriverResponse> getAllDrivers() {
        return driverdao.findAll().stream().
                map(DriverResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public DriverResponse updateDriver(@RequestBody DriverRequest driverRequest, @PathVariable Long id) {
        Driver driver =driverdao.findById(id).orElseThrow(
                ()->new RuntimeException("driver not found with this id:"+id));
        if(driver !=null){
            Driver d = DriverResponse.toEntity(driverRequest);
            d.setId(id);
            Driver savedDriver=driverdao.save(d);
            return DriverResponse.fromEntity(savedDriver);
        }else{
            return  null;
        }

    }

    @Override
    public HashMap<String, String> deleteDriver(Long id) {
        HashMap message = new HashMap<>();
        Driver driver=driverdao.findById(id).orElseThrow(null);
        if(driver!=null){
            try{
                driverdao.deleteById(id);
                message.put("driver","driverdeleted successfully");
            }catch(Exception e){
                message.put("driver",e.getMessage());
            }
        }else {
            message.put("message", "driver not found" + id);
        }
        return message;
    }
}
