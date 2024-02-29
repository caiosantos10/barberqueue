package com.santos.barberqueue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santos.barberqueue.domain.BarberShopService;

@Repository
public interface BarberShopServiceRepository extends JpaRepository<BarberShopService, Integer> {

}
