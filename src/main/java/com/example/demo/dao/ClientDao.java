package com.example.demo.dao;

import com.example.demo.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository <ClientEntity,Integer> {
    ClientEntity findByNom(String nom);
}
