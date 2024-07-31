package com.ma.firstapi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ma.firstapi.models.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends JpaRepository<Client,Integer> {

    Client findByNom(String nom);



}
