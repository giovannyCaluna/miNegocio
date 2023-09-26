package com.challenge.alquimiasoft.IRepository;

import com.challenge.alquimiasoft.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClientRepository extends JpaRepository<Client, Long> {
}