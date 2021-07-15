package com.dev.springlocationapi.repository;

import com.dev.springlocationapi.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    Address getById(Long id);

    void deleteById(Long id);
}
