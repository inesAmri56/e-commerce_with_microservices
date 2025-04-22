package com.example.clientservice.service;
import com.example.clientservice.dtos.request.ClientRequest;
import com.example.clientservice.dtos.response.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    ClientResponse getClientById(Long id);
    List<ClientResponse> getAllClients();
    ClientResponse updateClient(ClientRequest clientRequest,Long id);
    HashMap<String,String> deleteClient(Long id);
}
