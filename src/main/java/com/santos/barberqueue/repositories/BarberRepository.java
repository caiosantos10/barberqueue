package com.santos.barberqueue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santos.barberqueue.domain.Barber;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Integer> {

}
