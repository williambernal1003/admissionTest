package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;
    @GetMapping("/allMedication")
    public ResponseEntity<List<Medication>> getMedicationById() {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.listallMedication());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping("")
    public ResponseEntity<Medication> save(@RequestBody Medication med){
        System.out.println(med.getCategory());
        System.out.println(med.getExpirationDate());
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.save(med));
    }

    @GetMapping("/medicamentos")
    public ResponseEntity<List<Medication>> getExpiringMedications(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio) {
        List<Medication> medicamentos = medicationUseCase.getMedicationsExpiringBefore(fechaInicio);
        return ResponseEntity.ok(medicamentos);
    }

}
