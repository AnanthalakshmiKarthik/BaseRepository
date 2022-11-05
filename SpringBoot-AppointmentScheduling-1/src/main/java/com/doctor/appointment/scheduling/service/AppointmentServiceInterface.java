package com.doctor.appointment.scheduling.service;

import org.springframework.stereotype.Service;

import com.doctor.appointment.scheduling.entity.Appointment;

@Service
public interface AppointmentServiceInterface {

	public Appointment rescheduleAppointment(Integer patientId, Appointment updatedAppointment);

	public Appointment cancelAppointment(Integer patientId, Integer appointmentId);

}
