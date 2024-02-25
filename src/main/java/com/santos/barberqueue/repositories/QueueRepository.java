package com.santos.barberqueue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santos.barberqueue.domain.Queue;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Integer> {

}
