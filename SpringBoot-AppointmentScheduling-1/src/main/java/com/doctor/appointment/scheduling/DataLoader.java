package com.doctor.appointment.scheduling;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.doctor.appointment.scheduling.entity.Appointment;
import com.doctor.appointment.scheduling.entity.Doctor;
import com.doctor.appointment.scheduling.entity.Patient;
import com.doctor.appointment.scheduling.entity.Provider;
import com.doctor.appointment.scheduling.enums.EnumCommunicationMode;
import com.doctor.appointment.scheduling.enums.EnumDoctorSpeciality;
import com.doctor.appointment.scheduling.enums.EnumGender;
import com.doctor.appointment.scheduling.repository.AppointmentRepository;
import com.doctor.appointment.scheduling.repository.DoctorRepository;
import com.doctor.appointment.scheduling.repository.LocationRepository;
import com.doctor.appointment.scheduling.repository.PatientRepository;
import com.doctor.appointment.scheduling.repository.ProviderRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Component
public class DataLoader implements ApplicationRunner {

	private PatientRepository patientRepo;
	private DoctorRepository doctorRepo;
	private AppointmentRepository appointmentRepo;
	private ProviderRepository providerRepo;
	private LocationRepository roleRepo;

	@Autowired
	public DataLoader(PatientRepository patientRepo, DoctorRepository doctorRepo, AppointmentRepository appointmentRepo,
			ProviderRepository providerRepo, LocationRepository roleRepo) {
		this.patientRepo = patientRepo;
		this.doctorRepo = doctorRepo;
		this.appointmentRepo = appointmentRepo;
		this.providerRepo = providerRepo;
		this.roleRepo = roleRepo;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Appointment> appList = new ArrayList<Appointment>();
		Patient patient1 = new Patient();
		patient1.setPatientId(101);
		patient1.setFirstName("patient1fn");
		patient1.setLastName("patient1ln");
		patient1.setEmail("patient1@gmail.com");
		patient1.setAge(34);
		patient1.setGender(EnumGender.MALE);
		patient1.setPhone("2345678987");
		patient1.setPassword("password");
		patient1.setAppointmentsList(appList);
		patient1.setCoPay(345.98);
		patient1.setIsRegistered(true);
		patient1.setProvider(null);

		patientRepo.save(patient1);
		
		List<Provider> providerList = new ArrayList<Provider>();
		Doctor doctor1 = new Doctor();
		doctor1.setDoctorId(111);
		doctor1.setFirstName("doctor1fn");
		doctor1.setLastName("doctor1ln");
		doctor1.setEmail("doctor1mail@gmail.com");
		doctor1.setPhoneNum("2345543234");
		doctor1.setSpecialty(EnumDoctorSpeciality.CARDIALOGIST);
		doctor1.setAppointmentLists(appList);
		doctor1.setProviderList(providerList);
		doctorRepo.save(doctor1);
		
		Doctor doctor2 = new Doctor();
		doctor2.setDoctorId(222);
		doctor2.setFirstName("doctor2fn");
		doctor2.setLastName("doctor2ln");
		doctor2.setEmail("doctor2mail@gmail.com");
		doctor2.setPhoneNum("2345543234");
		doctor2.setSpecialty(EnumDoctorSpeciality.NEPHROLOGY);
		doctor2.setAppointmentLists(appList);
		doctor2.setProviderList(providerList);
		doctorRepo.save(doctor2);
		
		
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patient1);
		Provider provider1 = new Provider();
		provider1.setProviderId(211);
		provider1.setProviderName("Provider1");
		provider1.setDoctor(doctor1);
		provider1.setSpecialty(EnumDoctorSpeciality.CARDIALOGIST);
		provider1.setPhoneNum("2345665432");
		provider1.setEmail("provider1@gmail.com");
		provider1.setPatientsList(patientList);
		providerRepo.save(provider1);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		
		
		Appointment appointment1 = new Appointment();
		
		appointment1.setAppointmentId(1234);
		appointment1.setPatient(patient1);
		appointment1.setDoctor(doctor1);
		appointment1.setAppointmentDate(date);
		appointment1.setReasonForVisit("checkup");
		appointment1.setTypeOfVisit("general");
		appointment1.setCommunicationMode(EnumCommunicationMode.EMAIL);
		appointmentRepo.save(appointment1);
		
		List<Appointment> existingAppts = doctor1.getAppointmentLists();
		existingAppts.add(appointment1);
		doctor1.setAppointmentLists(existingAppts);
		doctorRepo.save(doctor1);
		
		patient1.setAppointmentsList(existingAppts);
		patientRepo.save(patient1);

	}
}
