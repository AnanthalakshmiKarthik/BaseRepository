package com.doctor.appointment.scheduling.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.doctor.appointment.scheduling.enums.EnumDoctorSpeciality;

@Table(name="tbl_doctor")
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNum;
	
	@Enumerated(EnumType.STRING)
	private EnumDoctorSpeciality specialty;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_appt_id")
	private List<Appointment> appointmentLists;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_provider_id")
	private List<Provider> providerList;
	
	public Doctor() {
		
	}

	public Doctor(Integer doctorId, String firstName, String lastName, String email, String phoneNum,
			EnumDoctorSpeciality specialty, List<Appointment> appointmentLists, List<Provider> providerList) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.specialty = specialty;
		this.appointmentLists = appointmentLists;
		this.providerList = providerList;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public EnumDoctorSpeciality getSpecialty() {
		return specialty;
	}

	public void setSpecialty(EnumDoctorSpeciality specialty) {
		this.specialty = specialty;
	}

	public List<Appointment> getAppointmentLists() {
		return appointmentLists;
	}

	public void setAppointmentLists(List<Appointment> appointmentLists) {
		this.appointmentLists = appointmentLists;
	}

	public List<Provider> getProviderList() {
		return providerList;
	}

	public void setProviderList(List<Provider> providerList) {
		this.providerList = providerList;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNum=" + phoneNum + ", specialty=" + specialty + ", appointmentLists="
				+ appointmentLists + ", providerList=" + providerList + "]";
	}
	
	

}
