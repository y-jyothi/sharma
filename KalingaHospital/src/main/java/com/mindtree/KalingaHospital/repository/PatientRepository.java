package com.mindtree.KalingaHospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.KalingaHospital.entity.Patient;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
