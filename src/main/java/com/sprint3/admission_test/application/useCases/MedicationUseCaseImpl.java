package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;

    @Override
    public List<Medication> listallMedication() {
        return medicationRepository.listallMedication();
    }

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public Medication save(Medication med) {
        try {
            return medicationRepository.save(med);
        } catch (Exception ex) {
            throw new NotFoundException("No fue posible guardar la entidad: " + ex.getMessage());
        }
    }

    @Override
    public List<Medication> getMedicationsExpiringBefore(LocalDate fechaInicio) {
        return medicationRepository.getMedicationsExpiringBefore(fechaInicio);
    }
}
