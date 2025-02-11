
package com.wecp.healthcare_appointment_management_system.controller;

import com.wecp.healthcare_appointment_management_system.dto.TimeDto;
import com.wecp.healthcare_appointment_management_system.entity.Appointment;
import com.wecp.healthcare_appointment_management_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/receptionist")
public class ReceptionistController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> createAppointment(@RequestParam Long patientId, @RequestParam Long doctorId, @RequestBody TimeDto appointmentTime) {
        Appointment appointment = appointmentService.bookAppointment(patientId, doctorId, appointmentTime.getTime());
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/appointment-reschedule/{appointmentId}")
    public ResponseEntity<Appointment> rescheduleAppointment(@PathVariable Long appointmentId, @RequestBody TimeDto newTime) {
        Appointment updatedAppointment = appointmentService.rescheduleAppointment(appointmentId, newTime.getTime());
        return ResponseEntity.ok(updatedAppointment);
    }
}