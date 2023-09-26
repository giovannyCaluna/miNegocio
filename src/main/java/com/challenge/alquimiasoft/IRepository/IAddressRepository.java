package com.challenge.alquimiasoft.IRepository;

import com.challenge.alquimiasoft.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAddressRepository extends JpaRepository<Address, Long> {
}