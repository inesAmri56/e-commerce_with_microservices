package com.example.providerservice.repository;

import com.example.providerservice.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderDAO extends JpaRepository<Provider,Long> {
}
