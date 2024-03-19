package com.santos.barberqueue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santos.barberqueue.domain.Avaliability;

@Repository
public interface AvaliabilityRepository extends JpaRepository<Avaliability, Integer> {

}
