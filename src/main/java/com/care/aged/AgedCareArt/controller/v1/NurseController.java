package com.care.aged.AgedCareArt.controller.v1;

import com.care.aged.AgedCareArt.converters.PatientRequestToPatient;
import com.care.aged.AgedCareArt.converters.PatientToPatientResponse;
import com.care.aged.AgedCareArt.entity.Patient;
import com.care.aged.AgedCareArt.protocol.patient.PatientRequest;
import com.care.aged.AgedCareArt.protocol.patient.PatientResponse;
import com.care.aged.AgedCareArt.service.PatientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/nurses")
public class NurseController {

    private final PatientService service;
    private final PatientRequestToPatient patientRequestToPatient;
    private final PatientToPatientResponse patientToPatientResponse;

    public NurseController(
            final PatientService service,
            final PatientRequestToPatient patientRequestToPatient,
            final PatientToPatientResponse patientToPatientResponse) {
        this.service = service;
        this.patientRequestToPatient = patientRequestToPatient;
        this.patientToPatientResponse = patientToPatientResponse;
    }

/*    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO<Iterable<Patient>>> findAll() {
        return ResponseEntity.ok(new ResponseVO<>(userService.findAll()));
    }*/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientResponse createPatient(@RequestBody PatientRequest request) {
        Patient patient = service.save(patientRequestToPatient.convert(request));
        return patientToPatientResponse.convert(patient);
    }
}
