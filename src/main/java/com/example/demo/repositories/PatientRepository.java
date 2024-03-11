package com.example.demo.repositories;

import com.example.demo.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Page<Patient> findByNomContainingOrPrenomContainingIgnoreCase(String nom, String prenom, Pageable pageable);
}
