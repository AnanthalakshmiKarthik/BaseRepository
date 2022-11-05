package com.doctor.appointment.scheduling.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.doctor.appointment.scheduling.enums.EnumAppointmentStatus;
import com.doctor.appointment.scheduling.enums.EnumCommunicationMode;
import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "tbl_appointment")
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentId;

	@ManyToOne
	@JoinColumn(name = "appt_patient_id")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "appt_doctor_id")
	private Doctor doctor;

	@Enumerated(EnumType.STRING)
	private EnumAppointmentStatus appointmentStatus;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date appointmentDate;

	private String reasonForVisit;

	private String typeOfVisit;

	private String reasonForConcellation;

	@Enumerated(EnumType.STRING)
	private EnumCommunicationMode communicationMode;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_provider_id")
    private Provider provider;

	public Appointment() {

	}

	public Appointment(Integer appointmentId, Patient patient, Doctor doctor, EnumAppointmentStatus appointmentStatus,
			Date appointmentDate, String reasonForVisit, String typeOfVisit,
			String reasonForConcellation, EnumCommunicationMode communicationMode, Provider provider) {
		this.appointmentId = appointmentId;
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentStatus = appointmentStatus;
		this.appointmentDate = appointmentDate;
		this.reasonForVisit = reasonForVisit;
		this.typeOfVisit = typeOfVisit;
		this.reasonForConcellation = reasonForConcellation;
		this.communicationMode = communicationMode;
		this.provider = provider;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public EnumAppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(EnumAppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public String getTypeOfVisit() {
		return typeOfVisit;
	}

	public void setTypeOfVisit(String typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}

	public String getReasonForConcellation() {
		return reasonForConcellation;
	}

	public void setReasonForConcellation(String reasonForConcellation) {
		this.reasonForConcellation = reasonForConcellation;
	}

	public EnumCommunicationMode getCommunicationMode() {
		return communicationMode;
	}

	public void setCommunicationMode(EnumCommunicationMode communicationMode) {
		this.communicationMode = communicationMode;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patient=" + patient + ", doctor=" + doctor
				+ ", appointmentStatus=" + appointmentStatus + ", appointmentDate=" + appointmentDate +", reasonForVisit=" + reasonForVisit + ", typeOfVisit="
				+ typeOfVisit + ", reasonForConcellation=" + reasonForConcellation + ", communicationMode="
				+ communicationMode + ", provider=" + provider + "]";
	}

	
}
