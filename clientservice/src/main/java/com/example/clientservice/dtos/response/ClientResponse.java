package com.example.clientservice.dtos.response;
import com.example.clientservice.dtos.request.ClientRequest;
import com.example.clientservice.model.Client;
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
public class ClientResponse {
    private Long id;
    private  String localization;
   // List<OrderResponse> orders;
    public static ClientResponse fromEntity(Client client){
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(client,clientResponse);
//        if(client.getOrders()!=null){
//            //Conversion des ordres
//            clientResponse.setOrders(client.getOrders().
//                    stream().map(OrderResponse::fromEntity).collect(Collectors.toList()));
//        }
        return clientResponse;
    }
    public static Client toEntity(ClientRequest request){
        Client client= new Client();
        BeanUtils.copyProperties(request, client);
        return  client;
    }
}
