package com.wecp.healthcare_appointment_management_system.controller;

import com.wecp.healthcare_appointment_management_system.entity.Appointment;
import com.wecp.healthcare_appointment_management_system.entity.Doctor;
import com.wecp.healthcare_appointment_management_system.service.AppointmentService;
import com.wecp.healthcare_appointment_management_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/api/doctor/availability")
    public ResponseEntity<Doctor> updateAvailability(@RequestParam Long doctorId, @RequestParam String availability) {
        Doctor updatedDoctor = doctorService.updateAvailability(doctorId, availability);
        return ResponseEntity.ok(updatedDoctor);
    }

    @GetMapping("/api/doctor/appointments")
    public ResponseEntity<List<Appointment>> getAppointments(@RequestParam Long doctorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }
}
