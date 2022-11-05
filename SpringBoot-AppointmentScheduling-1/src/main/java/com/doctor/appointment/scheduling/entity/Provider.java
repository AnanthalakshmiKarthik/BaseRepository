package com.doctor.appointment.scheduling.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.doctor.appointment.scheduling.enums.EnumDoctorSpeciality;

@Table(name = "tbl_provider")
@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer providerId;

	private String providerName;

	@ManyToOne
	@JoinColumn(name = "provider_doctor_id")
	private Doctor doctor;

	@Enumerated(EnumType.STRING)
	private EnumDoctorSpeciality specialty;

	private String email;

	private String phoneNum;

//	@OneToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "provider_location_id")
//	private Location providerLocation;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_patient_id")
	private List<Patient> patientsList;
	
	

	public Provider() {

	}

	public Provider(Integer providerId, String providerName, Doctor doctor, EnumDoctorSpeciality specialty,
			String email, String phoneNum, /*Location providerLocation,*/ List<Patient> patientsList) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.doctor = doctor;
		this.specialty = specialty;
		this.email = email;
		this.phoneNum = phoneNum;
		//this.providerLocation = providerLocation;
		this.patientsList = patientsList;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public EnumDoctorSpeciality getSpecialty() {
		return specialty;
	}

	public void setSpecialty(EnumDoctorSpeciality specialty) {
		this.specialty = specialty;
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

//	public Location getLocation() {
//		return providerLocation;
//	}
//
//	public void setLocation(Location providerLocation) {
//		this.providerLocation = providerLocation;
//	}

	public List<Patient> getPatientsList() {
		return patientsList;
	}

	public void setPatientsList(List<Patient> patientsList) {
		this.patientsList = patientsList;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName=" + providerName + ", doctor=" + doctor
				+ ", specialty=" + specialty + ", email=" + email + ", phoneNum=" + phoneNum + ", location=" /*+ providerLocation*/
				+ ", patientsList=" + patientsList + "]";
	}

}
