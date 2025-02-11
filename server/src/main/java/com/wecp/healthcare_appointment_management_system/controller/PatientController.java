

package com.wecp.healthcare_appointment_management_system.controller;

import com.wecp.healthcare_appointment_management_system.entity.Appointment;
import com.wecp.healthcare_appointment_management_system.entity.Doctor;
import com.wecp.healthcare_appointment_management_system.entity.MedicalRecord;
import com.wecp.healthcare_appointment_management_system.service.AppointmentService;
import com.wecp.healthcare_appointment_management_system.service.DoctorService;
import com.wecp.healthcare_appointment_management_system.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> bookAppointment(@RequestParam Long patientId, @RequestParam Long doctorId, @RequestParam Date appointmentTime) {
        Appointment appointment = appointmentService.bookAppointment(patientId, doctorId, appointmentTime);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments(@RequestParam Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/medicalrecords")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecords(@RequestParam Long patientId) {
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsByPatientId(patientId);
        return ResponseEntity.ok(medicalRecords);
    }
}
