package com.care.aged.AgedCareArt.controller.v1;

import com.care.aged.AgedCareArt.converters.DoctorRequestToDoctor;
import com.care.aged.AgedCareArt.converters.DoctorToDoctorResponse;
import com.care.aged.AgedCareArt.entity.Doctor;
import com.care.aged.AgedCareArt.entity.Patient;
import com.care.aged.AgedCareArt.exception.GenericServiceException;
import com.care.aged.AgedCareArt.protocol.admin.LinkDoctorPatientRequest;
import com.care.aged.AgedCareArt.protocol.doctor.DoctorRequest;
import com.care.aged.AgedCareArt.protocol.doctor.DoctorResponse;
import com.care.aged.AgedCareArt.service.DoctorService;
import com.care.aged.AgedCareArt.service.PatientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final DoctorRequestToDoctor doctorRequestToDoctor;
    private final DoctorToDoctorResponse doctorToDoctorResponse;

    public AdminController(
            final DoctorService doctorService,
            final PatientService patientService,
            final DoctorRequestToDoctor doctorRequestToDoctor,
            final DoctorToDoctorResponse doctorToDoctorResponse) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.doctorRequestToDoctor = doctorRequestToDoctor;
        this.doctorToDoctorResponse = doctorToDoctorResponse;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/link")
    public void linkDoctor(@RequestBody LinkDoctorPatientRequest request) {

        Doctor doctor = doctorService.search(request.getDoctorName());
        Patient patient = patientService.search(request.getPatientName());

        if (doctor == null || patient == null) {
            throw new GenericServiceException("Entry not found");
        } else {
            List<Patient> patientList = doctor.getPatients();
            if (patientList == null) {
                doctor.setPatients(Collections.singletonList(patient));
            } else {
                patientList.add(patient);
                doctor.setPatients(patientList);
            }
            doctorService.update(doctor);
            patient.setDoctor(doctor);
            patientService.update(patient);
        }
    }


}
