package com.company.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.booking.entity.ReserveEntity;

public interface  ReservationRepository extends JpaRepository<ReserveEntity, Long> {
	
}
