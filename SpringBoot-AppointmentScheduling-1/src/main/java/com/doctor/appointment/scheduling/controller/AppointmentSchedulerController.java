package com.doctor.appointment.scheduling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.appointment.scheduling.entity.Appointment;
import com.doctor.appointment.scheduling.service.AppointmentServiceImpl;

@RestController
@RequestMapping("/api/v1/")
public class AppointmentSchedulerController {

	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;

	@PutMapping(path = "appointment_scheduling_app/patient/{id}/appointments/", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Appointment> rescheduleAppointment(@PathVariable("id") Integer id,
			@RequestBody Appointment updatedAppointment) {

		Appointment rescheduledAppointment = appointmentServiceImpl.rescheduleAppointment(id, updatedAppointment);
		return new ResponseEntity<Appointment>(rescheduledAppointment, HttpStatus.CREATED);
	}

	@PutMapping(path = "appointment_scheduling_app/patient/{pId}/appointments/{aId}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Appointment> cancelAppointment(@PathVariable("pId") Integer pId,
			@PathVariable("aId") Integer aId) {
		Appointment cancelledAppointment = appointmentServiceImpl.cancelAppointment(aId, aId);
		return new ResponseEntity<Appointment>(cancelledAppointment, HttpStatus.CREATED);
	}

}
