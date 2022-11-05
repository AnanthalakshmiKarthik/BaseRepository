package com.doctor.appointment.scheduling.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tbl_location")
@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;
	private String street;
	private String state;
	private String city;
	private String zipcode;

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_provider_id")
	private Provider provider;

	public Location() {

	}

	public Location(Integer locationId, String street, String state, String city, String zipcode,Provider provider) {
		this.locationId = locationId;
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.provider = provider;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", street=" + street + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + ", provider=" + provider +"]";
	}

}
