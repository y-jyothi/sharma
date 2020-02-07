package com.mindtree.KalingaHospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.KalingaHospital.entity.Doctor;
import com.mindtree.KalingaHospital.entity.Patient;
import com.mindtree.KalingaHospital.service.HospitalService;

@Controller
public class AppController {

	@Autowired
	private HospitalService ser;

	@GetMapping("/getform")
	public String form1() {
		return "index";
	}

	@RequestMapping("/doctors")
	public String form2() {
		return "registerDoctors";
	}

	@PostMapping("/insertdoctors")
	public String insertdoc(Doctor doctor) {
		ser.insertIntoToDb(doctor);
		// m.addAttribute("doctor", doctor);
		return "doctorInserted";
	}

	@RequestMapping("/patients")
	public String form3(Model m) {
		List<Doctor> doctors = ser.getAllDoctors();
		m.addAttribute("doctors", doctors);
		return "registerPatient";
	}

	@PostMapping("/insertPatients")
	public String insertPatient(Patient patient, String doctorName) {
		ser.insertPatientIntoDb(patient, doctorName);

		return "patientInserted";
	}

	@GetMapping("/displaypatient")
	public String getpatient(Model m) {
		List<Doctor> doctors = ser.getAllDoctors();

		m.addAttribute("doctors", doctors);
		return "display";
	}

	@GetMapping("/viewdetails")
	public String getPatientsdetails(@RequestParam("doctors") String doctorName, Model m) {
		List<Patient> patients = ser.getPatients(doctorName);
		for (Patient patient : patients) {
			System.out.println(patient);
		}
		m.addAttribute("patients", patients);
		return "display";

	}

	@GetMapping("/displaydoctors")

	public String getEmployee(Model m) {
		List<Doctor> doc = ser.getAllsorteddoctor();
		m.addAttribute("list", doc);
		return "viewDoctors";

	}

}
