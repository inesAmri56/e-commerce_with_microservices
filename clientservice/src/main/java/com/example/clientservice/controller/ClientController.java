package com.example.clientservice.controller;
import com.example.clientservice.dtos.request.ClientRequest;
import com.example.clientservice.dtos.response.ClientResponse;
import com.example.clientservice.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientapi")
public class ClientController {
    public static ClientService clientservice;
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientservice = clientService;
        this.clientService = clientService;
    }

    @PostMapping("/createClient")
    public ClientResponse createClent(@RequestBody ClientRequest clientRequest) {
        return clientservice.createClient(clientRequest);
    }

    @GetMapping("/allclients")
    public List<ClientResponse> getallClients() {
        return clientservice.getAllClients();
    }

    @GetMapping("clientById/{id}")
    public ClientResponse getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }
    @PutMapping("/updateClient/{id}")
    public ClientResponse updateClient(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        return clientService.updateClient(clientRequest, id);
    }

    @DeleteMapping("/deleteClient/{id}")
    public HashMap<String, String> deleteClientById(@PathVariable Long id) {
        return clientservice.deleteClient(id);
    }}

