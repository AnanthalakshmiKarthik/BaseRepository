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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.doctor.appointment.scheduling.enums.EnumGender;


@Table(name="tbl_patient")
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Email
	private String email;
	
	@Max(value = 100, message = "must be less than or equal to 100")
	private Integer age;

	@Enumerated(EnumType.STRING)
	private EnumGender gender;

	@NotBlank
	private String phone;
	
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment> appointmentsList;
	private Double coPay;
	private Boolean isRegistered;
	
	@ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

	public Patient() {

	}

	public Patient(Integer patientId, String firstName, String lastName, String email, Integer age, EnumGender gender,
			String phone, String password, List<Appointment> appointmentsList, Double coPay, Boolean isRegistered,
			Provider provider) {
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.password = password;
		this.appointmentsList = appointmentsList;
		this.coPay = coPay;
		this.isRegistered = isRegistered;
		this.provider = provider;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public EnumGender getGender() {
		return gender;
	}

	public void setGender(EnumGender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Appointment> getAppointmentsList() {
		return appointmentsList;
	}

	public void setAppointmentsList(List<Appointment> appointmentsList) {
		this.appointmentsList = appointmentsList;
	}

	public Double getCoPay() {
		return coPay;
	}

	public void setCoPay(Double coPay) {
		this.coPay = coPay;
	}

	public Boolean getIsRegistered() {
		return isRegistered;
	}

	public void setIsRegistered(Boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", password=" + password
				+ ", appointmentsList=" + appointmentsList + ", coPay=" + coPay + ", isRegistered=" + isRegistered
				+ ", provider=" + provider + "]";
	}

	

}
