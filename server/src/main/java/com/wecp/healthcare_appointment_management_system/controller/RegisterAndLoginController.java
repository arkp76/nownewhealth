package com.wecp.healthcare_appointment_management_system.controller;


import com.wecp.healthcare_appointment_management_system.dto.LoginRequest;
import com.wecp.healthcare_appointment_management_system.dto.LoginResponse;
import com.wecp.healthcare_appointment_management_system.entity.Doctor;
import com.wecp.healthcare_appointment_management_system.entity.Patient;
import com.wecp.healthcare_appointment_management_system.entity.Receptionist;
import com.wecp.healthcare_appointment_management_system.entity.User;
import com.wecp.healthcare_appointment_management_system.jwt.JwtUtil;
import com.wecp.healthcare_appointment_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


public class RegisterAndLoginController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/api/patient/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        // register patient
        Patient savedPatient = (Patient) userService.registerUser(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PostMapping("/api/doctors/register")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor) {
        // register doctor
        Doctor savedDoctor = (Doctor) userService.registerUser(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @PostMapping("/api/receptionist/register")
    public ResponseEntity<Receptionist> registerReceptionist(@RequestBody Receptionist receptionist) {
       // register receptionist
       Receptionist savedReceptionist = (Receptionist) userService.registerUser(receptionist);
        return ResponseEntity.ok(savedReceptionist);
    }

    @PostMapping("/api/user/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
      // login user and return jwt in LoginResponse object
        // return 401 unauthorized if authentication fail
        {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
                )
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }

        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        User user = userService.getUserByUsername(loginRequest.getUsername());

        LoginResponse loginResponse = new LoginResponse(
            user.getId(),
            jwt,
            user.getUsername(),
            user.getEmail(),
            user.getRole()
        );

        return ResponseEntity.ok(loginResponse);
    }
    }
}
