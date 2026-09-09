package com.company.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.booking.entity.ResourceEntity;

public interface ResourceRepository  extends JpaRepository<ResourceEntity, Long> {

}
