package com.wecp.healthcare_appointment_management_system.service;

import com.wecp.healthcare_appointment_management_system.entity.Appointment;
import com.wecp.healthcare_appointment_management_system.entity.Doctor;
import com.wecp.healthcare_appointment_management_system.entity.Patient;
import com.wecp.healthcare_appointment_management_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment addAppointment(Long patientId, Long doctorId, Date appointmentTime) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(appointmentTime.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        appointment.setStatus("Scheduled");

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public Appointment rescheduleAppointment(Long appointmentId, Date newTime) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointment.setAppointmentTime(newTime.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        return appointmentRepository.save(appointment);
    }
}
