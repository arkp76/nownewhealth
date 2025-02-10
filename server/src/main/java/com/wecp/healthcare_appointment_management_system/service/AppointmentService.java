

package com.wecp.healthcare_appointment_management_system.service;

import com.wecp.healthcare_appointment_management_system.entity.Appointment;
import com.wecp.healthcare_appointment_management_system.entity.Doctor;
import com.wecp.healthcare_appointment_management_system.entity.Patient;
import com.wecp.healthcare_appointment_management_system.repository.AppointmentRepository;
import com.wecp.healthcare_appointment_management_system.repository.DoctorRepository;
import com.wecp.healthcare_appointment_management_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment bookAppointment(Long patientId, Long doctorId, Date appointmentTime) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setStatus("BOOKED");

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment rescheduleAppointment(Long appointmentId, Date newTime) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setAppointmentTime(newTime);
        appointment.setStatus("RESCHEDULED");
        return appointmentRepository.save(appointment);
    }
}













// // package com.wecp.healthcare_appointment_management_system.service;

// // import com.wecp.healthcare_appointment_management_system.entity.Appointment;
// // import com.wecp.healthcare_appointment_management_system.entity.Doctor;
// // import com.wecp.healthcare_appointment_management_system.entity.Patient;
// // import com.wecp.healthcare_appointment_management_system.repository.*;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Service;
// // import org.springframework.transaction.annotation.Transactional;
// //import java.util.Date;


// // import java.time.LocalDateTime;
// // import java.util.List;

// // @Service
// // public class AppointmentService {


// //     @Autowired
// //     private AppointmentRepository appointmentRepository;

// //     @Autowired
// //     private PatientRepository patientRepository;

// //     @Autowired
// //     private DoctorRepository doctorRepository;

// //     public Appointment addAppointment(Long patientId, Long doctorId, Date appointmentTime) {
// //         Patient patient = patientRepository.findById(patientId).orElseThrow();
// //         Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

// //         Appointment appointment = new Appointment();
// //         appointment.setPatient(patient);
// //         appointment.setDoctor(doctor);
// //         appointment.setAppointmentTime(appointmentTime.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
// //         appointment.setStatus("Scheduled");

// //         return appointmentRepository.save(appointment);
// //     }

// //     public List<Appointment> getAllAppointments() {
// //         return appointmentRepository.findAll();
// //     }

// //     public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
// //         return appointmentRepository.findByDoctorId(doctorId);
// //     }

// //     public List<Appointment> getAppointmentsByPatientId(Long patientId) {
// //         return appointmentRepository.findByPatientId(patientId);
// //     }

// //     public Appointment rescheduleAppointment(Long appointmentId, Date newTime) {
// //         Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
// //         appointment.setAppointmentTime(newTime.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
// //         return appointmentRepository.save(appointment);
// //     }
// // }



// package com.wecp.healthcare_appointment_management_system.service;

// import com.wecp.healthcare_appointment_management_system.entity.Appointment;
// import com.wecp.healthcare_appointment_management_system.entity.Doctor;
// import com.wecp.healthcare_appointment_management_system.entity.Patient;
// import com.wecp.healthcare_appointment_management_system.repository.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;


// import java.time.LocalDateTime;
// import java.util.Date;


// import java.util.List;


// @Service
// public class AppointmentService {

//     @Autowired
//     private AppointmentRepository appointmentRepository;

//     public Appointment bookAppointment(Long patientId, Long doctorId, Date appointmentTime) {
//         Appointment appointment = new Appointment();
//         appointment.setPatientId(patientId);
//         appointment.setDoctorId(doctorId);
//         appointment.setAppointmentTime(appointmentTime);
//         appointment.setStatus("BOOKED");
//         return appointmentRepository.save(appointment);
//     }

//     public List<Appointment> getAppointmentsByPatientId(Long patientId) {
//         return appointmentRepository.findByPatientId(patientId);
//     }

//     public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
//         return appointmentRepository.findByDoctorId(doctorId);
//     }

//     public List<Appointment> getAllAppointments() {
//         return appointmentRepository.findAll();
//     }

//     public Appointment rescheduleAppointment(Long appointmentId, Date newTime) {
//         Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
//         // .orElseThrow(() -> new RuntimeException("Appointment not found"));
//         appointment.setAppointmentTime(newTime);
//         appointment.setStatus("RESCHEDULED");
//         return appointmentRepository.save(appointment);
//     }

    
    
//         public Appointment findById(Long id){
//             return appointmentRepository.findById(id).orElseThrow();
//         }
    
//         public Appointment save(Appointment appointment) {
//             return appointmentRepository.save(appointment);
//         }
    
// }
