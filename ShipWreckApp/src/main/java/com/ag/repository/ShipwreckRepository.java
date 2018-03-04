package com.ag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ag.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
