package com.mindtree.KalingaHospital.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	



	@Id
	@Column(name="patientId")
	private int patientId;
	
	@Column(name="patientName")
	private String patientName;
	
	@Column(name="billAmount")
	private double billAmount;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Doctor doctor;

	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient(int patientId, String patientName, double billAmount, Doctor doctor) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.billAmount = billAmount;
		this.doctor = doctor;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}



	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

}
