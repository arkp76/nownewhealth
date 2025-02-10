


package com.wecp.healthcare_appointment_management_system.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TimeDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @JsonCreator
    public TimeDto(@JsonProperty("time") Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}











// package com.wecp.healthcare_appointment_management_system.dto;

// import com.fasterxml.jackson.annotation.JsonCreator;
// import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonProperty;

// import java.util.Date;

// /**
//  * @author Ubaid Khanzada
//  */
// public class TimeDto {

//     private int hours;
//     private int minutes;
//     private Long userId;
//     private Long doctorId;
//     private Long patientId;

//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//     private Date time;

//     @JsonCreator
//     public TimeDto(@JsonProperty("time") Date time) {
//         this.time = time;
//     }

//     public int getHours() {
//         return hours;
//     }

//     public void setHours(int hours) {
//         this.hours = hours;
//     }

//     public int getMinutes() {
//         return minutes;
//     }

//     public void setMinutes(int minutes) {
//         this.minutes = minutes;
//     }

//     public Long getUserId() {
//         return userId;
//     }

//     public void setUserId(Long userId) {
//         this.userId = userId;
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

//     public void setPatientId(Long patientId) {
//         this.patientId = patientId;
//     }

//     public Date getTime() {
//         return time;
//     }

//     public void setTime(Date time) {
//         this.time = time;
//     }
// }




