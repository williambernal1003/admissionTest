package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {
    List<Medication> listallMedication();
    Medication getMedicationById(Long id);
    Medication save(Medication med);
    List<Medication> getMedicationsExpiringBefore(LocalDate fociInitio);
}