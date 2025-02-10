
package com.wecp.healthcare_appointment_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long doctorId;
    private Long patientId;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<MedicalRecord> medicalRecords;

    private String specialty;
    private String availability;
    private String password; // Added password field
    private String username; // Added username field
    private String email; // Added email field
    private String role; // Added role field

    // Getters and Setters
    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() { // Added getPassword method
        return password;
    }

    public void setPassword(String password) { // Added setPassword method
        this.password = password;
    }

    public String getUsername() { // Added getUsername method
        return username;
    }

    public void setUsername(String username) { // Added setUsername method
        this.username = username;
    }

    public String getEmail() { // Added getEmail method
        return email;
    }

    public void setEmail(String email) { // Added setEmail method
        this.email = email;
    }

    public String getRole() { // Added getRole method
        return role;
    }

    public void setRole(String role) { // Added setRole method
        this.role = role;
    }
}








// package com.wecp.healthcare_appointment_management_system.entity;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import javax.persistence.Entity;
// import javax.persistence.OneToMany;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// import java.util.Set;

// @Entity
// public class Doctor {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long doctorId;
//     private Long patientId;

//     @OneToMany(mappedBy = "doctor")
//     @JsonIgnore
//     private Set<Appointment> appointments;

//     @OneToMany(mappedBy = "doctor")
//     @JsonIgnore
//     private Set<MedicalRecord> medicalRecords;

//     private String specialty;
//     private String availability;

//     // Getters and Setters
//     public Set<Appointment> getAppointments() {
//         return appointments;
//     }

//     public void setAppointments(Set<Appointment> appointments) {
//         this.appointments = appointments;
//     }

//     public Set<MedicalRecord> getMedicalRecords() {
//         return medicalRecords;
//     }

//     public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
//         this.medicalRecords = medicalRecords;
//     }

//     public String getSpecialty() {
//         return specialty;
//     }

//     public void setSpecialty(String specialty) {
//         this.specialty = specialty;
//     }

//     public String getAvailability() {
//         return availability;
//     }

//     public void setAvailability(String availability) {
//         this.availability = availability;
//     }

//     public Long getDoctorId() {
//         return doctorId;
//     }
    
//     public void setDoctorId(Long doctorId) {
//         this.doctorId = doctorId;
//     }
    
//     public Long getPatientId() {
//         return patientId;
//     }
    
//     public void setId(Long id) {
//         this.id = id;
//     }
    
//     public Long getId() {
//         return id;
//     }
// }
