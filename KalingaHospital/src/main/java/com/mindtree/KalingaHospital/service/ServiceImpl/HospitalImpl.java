package com.mindtree.KalingaHospital.service.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.KalingaHospital.entity.Doctor;
import com.mindtree.KalingaHospital.entity.Patient;
import com.mindtree.KalingaHospital.repository.DoctorRepository;
import com.mindtree.KalingaHospital.repository.PatientRepository;
import com.mindtree.KalingaHospital.service.HospitalService;

@Service
public class HospitalImpl implements HospitalService {

	@Autowired
	private DoctorRepository docRepo;

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public Doctor insertIntoToDb(Doctor doctor) {
		docRepo.save(doctor);
		return doctor;
	}

	@Override
	public Patient insertPatientIntoDb(Patient patient, String doctorName) {

		List<Doctor> doc = docRepo.findAll();

		Doctor doc1 = new Doctor();
		for (Doctor doctor : doc) {
			if (doctor.getDoctorName().equals(doctorName)) {

				doc1 = doctor;
				doc1.setSalary(doc1.getSalary() + patient.getBillAmount());

				patient.setDoctor(doc1);
			}

		}

		return patientRepo.saveAndFlush(patient);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = docRepo.findAll();
		return doctors;

	}

	@Override
	public List<Doctor> getAllsorteddoctor() {
		List<Doctor> doc = docRepo.findAll();
		Collections.sort(doc, new SortBySalary());
		return doc;

	}

	class SortBySalary implements Comparator<Doctor> {

		public int compare(Doctor a, Doctor b) {
			return (int) (b.getSalary() - a.getSalary());
		}
	}

	@Override
	public List<Patient> getPatients(String doctorName) {
		List<Patient> result = new ArrayList<Patient>();
		List<Patient> patients = patientRepo.findAll();
		
		for (Patient patient : patients) {
			System.out.println(patient);
			if (patient.getDoctor().getDoctorName().equals(doctorName)) {
				result.add(patient);
				System.out.println(patient);
			}
		}
		
		
		return result;
	}

}
