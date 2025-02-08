package com.wecp.healthcare_appointment_management_system.entity;
 
import javax.persistence.*;
import java.time.LocalDateTime;
 
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
   private Long id;
    private String patient;
    private String doctor;
    private LocalDateTime appointmentTime;
    private String status;
 
    @ManyToOne
    private Patient patient;
 
    @ManyToOne
    private Doctor doctor;
 
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getPatient() {
        return patient;
    }
 
    public void setPatient(String patient) {
        this.patient = patient;
    }
 
    public String getDoctor() {
        return doctor;
    }
 
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
 
    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }
 
    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public String getPatient() {
        return patient;
    }
 
    public void setPatient(String patient) {
        this.patient = patient;
    }
 
    public String getDoctor() {
        return doctor;
    }
 
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
 
}