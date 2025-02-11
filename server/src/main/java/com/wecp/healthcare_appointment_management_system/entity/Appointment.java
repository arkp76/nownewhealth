
package com.wecp.healthcare_appointment_management_system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="patient_id", insertable = false, updatable = false)
    private Long patientId;

    @Column(name="doctor_id", insertable = false, updatable = false)
    private Long doctorId;

    @Column(name="appointment_date")
    private Date appointmentDate;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private Date appointmentTime;
    private String status;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPatientId(Long patientId){
        this.patientId=patientId;
    }

    public Long getPatientId(){
        return patientId;
    }

    public void setDoctorId(Long doctorId){
        this.doctorId=doctorId;
    }

    public Long getDoctorId(){
        return doctorId;
    }

    public Date getAppointmentDate() { // Ensure this method exists
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
}










// package com.wecp.healthcare_appointment_management_system.entity;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.ManyToOne;
// import javax.persistence.Column;
// import java.util.Date;

// @Entity
// public class Appointment {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name="patient_id", insertable = false, updatable = false)
//     private Long patientId;

//     @Column(name="doctor_id", insertable = false, updatable = false)
//     private Long doctorId;

//     @ManyToOne
//     @JoinColumn(name = "patient_id", referencedColumnName = "id")
//     private Patient patient;

//     @ManyToOne
//     @JoinColumn(name = "doctor_id", referencedColumnName = "id")
//     private Doctor doctor;

//     private Date appointmentTime;
//     private String status;

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Patient getPatient() {
//         return patient;
//     }

//     public void setPatient(Patient patient) {
//         this.patient = patient;
//     }

//     public Doctor getDoctor() {
//         return doctor;
//     }

//     public void setDoctor(Doctor doctor) {
//         this.doctor = doctor;
//     }

//     public Date getAppointmentTime() {
//         return appointmentTime;
//     }

//     public void setAppointmentTime(Date appointmentTime) {
//         this.appointmentTime = appointmentTime;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public Long getPatientId() {
//         return patientId;
//     }

//     public void setPatientId(Long patientId) {
//         this.patientId = patientId;
//     }

//     public Long getDoctorId() {
//         return doctorId;
//     }

//     public void setDoctorId(Long doctorId) {
//         this.doctorId = doctorId;
//     }
// }
