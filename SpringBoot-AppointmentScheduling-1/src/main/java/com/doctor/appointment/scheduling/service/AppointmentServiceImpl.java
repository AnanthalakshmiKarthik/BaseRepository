package com.doctor.appointment.scheduling.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.appointment.scheduling.entity.Appointment;
import com.doctor.appointment.scheduling.entity.Patient;
import com.doctor.appointment.scheduling.exception.EntityNullException;
import com.doctor.appointment.scheduling.exception.ValidationException;
import com.doctor.appointment.scheduling.repository.AppointmentRepository;
import com.doctor.appointment.scheduling.repository.PatientRepository;

@Service
public class AppointmentServiceImpl implements AppointmentServiceInterface{
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public Appointment rescheduleAppointment(Integer patientId, Appointment updatedAppointment) {
		
		Optional<Patient> patientObj = patientRepo.findById(patientId);
		if(patientObj.isEmpty())
			throw new EntityNullException();
		if (updatedAppointment == null)
			throw new ValidationException();
		else
			return appointmentRepo.save(updatedAppointment);

	}

	@Override
	public Appointment cancelAppointment(Integer patientId, Integer appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
