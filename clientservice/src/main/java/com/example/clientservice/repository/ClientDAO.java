package com.example.clientservice.repository;



import com.example.clientservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client,Long> {
    List<Client> id(Long id);
}
