// package com.wecp.healthcare_appointment_management_system.controller;

// import com.wecp.healthcare_appointment_management_system.dto.TimeDto;
// import com.wecp.healthcare_appointment_management_system.entity.Appointment;
// import com.wecp.healthcare_appointment_management_system.entity.Doctor;
// import com.wecp.healthcare_appointment_management_system.entity.MedicalRecord;
// import com.wecp.healthcare_appointment_management_system.service.AppointmentService;
// import com.wecp.healthcare_appointment_management_system.service.DoctorService;
// import com.wecp.healthcare_appointment_management_system.service.MedicalRecordService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.*;

// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.Date;
// import java.util.List;

// @RestController
// public class PatientController {
//     @Autowired
//     private AppointmentService appointmentService;
//     @Autowired
//     private MedicalRecordService medicalRecordService; 
//     @Autowired
//     private DoctorService doctorService; 

//     @GetMapping("/api/patient/doctors")
//     public ResponseEntity<List<Doctor>> getDoctors() {
//         // get all doctors
//         List<Doctor> doctors=doctorService.getAllDoctors();
//         // return new ResponseEntity<>(doctors,HttpStatus.OK);
//         return ResponseEntity.ok(doctors);
        
//     }

//     @PostMapping("/api/patient/appointment")
//     public ResponseEntity<?> scheduleAppointment(@RequestParam Long patientId,
//                                                  @RequestParam Long doctorId,
//                                                  @RequestBody TimeDto timeDto) {
//       // schedule appointment
//       Appointment appointment = appointmentService.addAppointment(patientId, doctorId, timeDto.getTime());
//         return ResponseEntity.ok(appointment);
//     }

//     @GetMapping("/api/patient/appointments")
//     public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@RequestParam Long patientId) {
//         // get appointments by patient id
//          List<Appointment> appointments=appointmentService.getAllAppointments();
//         //return new ResponseEntity<>(appointments,HttpStatus.OK);
//         return ResponseEntity.ok(appointments);
//     }

//     @GetMapping("/api/patient/medicalrecords")
//     public ResponseEntity<List<MedicalRecord>> viewMedicalRecords(@RequestParam Long patientId) {
//         // view medical records
//          List<MedicalRecord> medicalRecords=medicalRecordService.getAppointmentsByPatientId();
//         // return new ResponseEntity<>(medicalRecords,HttpStatus.OK);
//         return ResponseEntity.ok(medicalRecords);
//     }
// }


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