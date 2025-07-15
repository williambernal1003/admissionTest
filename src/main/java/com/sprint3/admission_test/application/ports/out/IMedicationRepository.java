package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMedicationRepository {
    List<Medication> listallMedication();
    Optional<Medication> findById(Long id);
    Medication save(Medication med);
    List<Medication> getMedicationsExpiringBefore(LocalDate fechaInicio);
}
