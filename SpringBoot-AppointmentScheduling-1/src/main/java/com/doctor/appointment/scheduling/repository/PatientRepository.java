package com.doctor.appointment.scheduling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.appointment.scheduling.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
