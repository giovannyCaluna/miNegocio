package com.challenge.alquimiasoft.IRepository;

import com.challenge.alquimiasoft.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IAddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a WHERE a.client.id = :clientId")
    List<Address> findByClientId(@Param("clientId") Long clientId);
}