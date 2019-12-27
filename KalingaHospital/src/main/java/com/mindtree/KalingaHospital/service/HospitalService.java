package com.mindtree.KalingaHospital.service;

import java.util.List;

import com.mindtree.KalingaHospital.entity.Doctor;
import com.mindtree.KalingaHospital.entity.Patient;

public interface HospitalService {
	public Doctor insertIntoToDb(Doctor doctor);
	public Patient insertPatientIntoDb(Patient patient,String doctorName);
	public List<Doctor> getAllDoctors();
	public List<Doctor> getAllsorteddoctor();
	public List<Patient> getPatients(String doctorName);

}
