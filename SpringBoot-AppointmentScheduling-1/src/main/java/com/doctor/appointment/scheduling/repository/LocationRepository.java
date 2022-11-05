package com.doctor.appointment.scheduling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.appointment.scheduling.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
