package com.care.aged.AgedCareArt.controller.v1;

import com.care.aged.AgedCareArt.converters.DoctorRequestToDoctor;
import com.care.aged.AgedCareArt.converters.DoctorToDoctorResponse;
import com.care.aged.AgedCareArt.entity.Doctor;
import com.care.aged.AgedCareArt.entity.HealthRecord;
import com.care.aged.AgedCareArt.entity.Patient;
import com.care.aged.AgedCareArt.protocol.doctor.DoctorRequest;
import com.care.aged.AgedCareArt.protocol.doctor.DoctorResponse;
import com.care.aged.AgedCareArt.service.DoctorService;
import com.care.aged.AgedCareArt.service.HealthRecordService;
import com.care.aged.AgedCareArt.service.PatientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/doctors")
public class DoctorController {

    private final DoctorService service;
    private final PatientService patientService;
    private final HealthRecordService healthRecordService;
    private final DoctorRequestToDoctor doctorRequestToDoctor;
    private final DoctorToDoctorResponse doctorToDoctorResponse;

    public DoctorController(
            final DoctorService service,
            final PatientService patientService,
            final HealthRecordService healthRecordService,
            final DoctorRequestToDoctor doctorRequestToDoctor,
            final DoctorToDoctorResponse doctorToDoctorResponse) {
        this.service = service;
        this.patientService = patientService;
        this.healthRecordService = healthRecordService;
        this.doctorRequestToDoctor = doctorRequestToDoctor;
        this.doctorToDoctorResponse = doctorToDoctorResponse;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DoctorResponse createDoctor(@RequestBody DoctorRequest request) {
        Doctor doctor = service.save(doctorRequestToDoctor.convert(request));
        return doctorToDoctorResponse.convert(doctor);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{patientName}/updateinfo")
    public void updateInfo(@PathVariable("patientName") String name) {
        Patient patient = patientService.search(name);
        UUID uuid = UUID.randomUUID();
        // For testing updated as direct object// need to implement as payload

        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setPatient(patient);
        healthRecord.setAge(10);
        healthRecord.setClaims(uuid.toString());
        healthRecord.setHealthInfo(uuid.toString());
        healthRecord.setMedicare(uuid.toString());

        HealthRecord record = healthRecordService.save(healthRecord);
        patient.setHealthRecord(record);
        patientService.update(patient);
    }


    @GetMapping("/{patientName}/healthrecord")
    public HealthRecord getInfo(@PathVariable("patientName") String name) {
        Patient patient = patientService.search(name);
        HealthRecord record = null;
        if (patient != null) {
            record = healthRecordService.save(patient.getHealthRecord());
            patient.setHealthRecord(record);
            patientService.update(patient);
        } else {
            record = new HealthRecord();
            record.setAge(99);
            record.setClaims("Claiiiiims");
            record.setHealthInfo("Infoss");
            record.setHealthId(991L);
            record.setMedicare("Medicaire");
            record.setHealthSummary("SUMMARY");
        }
        return record;
    }

}
