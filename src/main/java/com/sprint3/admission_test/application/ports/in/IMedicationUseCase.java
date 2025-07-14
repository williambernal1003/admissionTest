package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.http.ResponseEntity;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    String save(Medication med);
}