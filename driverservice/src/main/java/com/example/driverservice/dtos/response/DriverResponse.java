package com.example.driverservice.dtos.response;


import com.example.driverservice.dtos.request.DriverRequest;
import com.example.driverservice.model.Driver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponse {
    private Long id;
    String adress;
   // List<OrderResponse>orders;
    public static DriverResponse fromEntity(Driver driver){
        DriverResponse  driverResponse = new DriverResponse();
        BeanUtils.copyProperties(driver,driverResponse);
//        if(driver.getOrders()!=null){
//            driverResponse.setOrders(driver.getOrders().stream()
//                    .map(OrderResponse::fromEntity).collect(Collectors.toList()));
//        }
        return driverResponse;
    }
    public static Driver toEntity(DriverRequest driverRequest){
        Driver driver = new Driver();
        BeanUtils.copyProperties(driverRequest,driver);
        return driver;
    }
}

