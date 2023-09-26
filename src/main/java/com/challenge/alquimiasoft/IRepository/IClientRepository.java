package com.challenge.alquimiasoft.IRepository;

import com.challenge.alquimiasoft.model.Address;
import com.challenge.alquimiasoft.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT a FROM Client a WHERE a.name LIKE CONCAT('%', :name, '%') OR a.identificationNumber LIKE CONCAT('%', :identificationNumber, '%')")
    List<Client> findBynameOrIdentification(@Param("name") String name,
                                            @Param("identificationNumber") String identificationNumber);

    @Query("SELECT a FROM Client a WHERE a.name LIKE CONCAT('%', :name, '%' )")
    List<Client> findByname(@Param("name") String name);

    @Query("SELECT a FROM Client a WHERE   a.identificationNumber LIKE CONCAT('%', :identificationNumber, '%')")
    List<Client> findByIdentification(@Param("identificationNumber") String identificationNumber);
}