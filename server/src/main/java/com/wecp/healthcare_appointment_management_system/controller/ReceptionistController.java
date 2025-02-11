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





// package com.wecp.healthcare_appointment_management_system.controller;

// import com.wecp.healthcare_appointment_management_system.entity.Appointment;
// import com.wecp.healthcare_appointment_management_system.service.AppointmentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.lang.Long;
// import java.util.Date;
// import java.util.List;

// @RestController
// @RequestMapping("/api/receptionist")
// public class ReceptionistController {

//     @Autowired
//     private AppointmentService appointmentService;

//     @GetMapping("/appointments")
//     public ResponseEntity<List<Appointment>> getAllAppointments() {
//         List<Appointment> appointments = appointmentService.getAllAppointments();
//         return ResponseEntity.ok(appointments);
//     }

//     @PostMapping("/appointment")
//     public ResponseEntity<Appointment> createAppointment(@RequestParam Long patientId, @RequestParam Long doctorId, @RequestParam Date appointmentTime) {
//         Appointment appointment = appointmentService.bookAppointment(patientId, doctorId, appointmentTime);
//         return ResponseEntity.ok(appointment);
//     }

//     @PutMapping("/appointment-reschedule/{appointmentId}")
//     public ResponseEntity<Appointment> rescheduleAppointment(@PathVariable Long appointmentId, @RequestParam Date newTime) {
//         Appointment updatedAppointment = appointmentService.rescheduleAppointment(appointmentId, newTime);
//         return ResponseEntity.ok(updatedAppointment);
//     }


// @PutMapping("/api/appointments/{id}/reschedule")
// public ResponseEntity<Appointment> rescheduleAppointment(@PathVariable Long id, @RequestBody TimeDto timedto) {
//     Appointment appointment = appointmentService.findById(id);
//             //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));
//     // Update appointment details
//     if(appointment!=null)
//     appointment.setAppointmentDate(newDetails.getAppointmentDate());
//     // Other updates...

//     Appointment updatedAppointment = appointmentService.save(appointment);

//     return ResponseEntity.ok(updatedAppointment);

// }


// }






















































