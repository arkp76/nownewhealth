import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment.development';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  //Just ensure that the endpoints (serverName and API paths) match your backend configuration.
  public serverName=environment.apiUrl;
 
 //todo:
  // http.service.ts
  constructor(private http:HttpClient){}
getDoctors(): Observable<any> {
  return this.http.get(`${this.serverName}/doctors`);
}

ScheduleAppointment(appointmentData: any): Observable<any> {
  return this.http.post(`${this.serverName}/appointments`, appointmentData);
}
// http.service.ts
registerPatient(data: any): Observable<any> {
  return this.http.post(`${this.serverName}/register/patient`, data);
}

registerDoctor(data: any): Observable<any> {
  return this.http.post(`${this.serverName}/register/doctor`, data);
}

registerReceptionist(data: any): Observable<any> {
  return this.http.post(`${this.serverName}/register/receptionist`, data);
}

ScheduleAppointmentByReceptionist(appointmentData: any): Observable<any> {
  return this.http.post(`${this.serverName}/appointments/receptionist`, appointmentData);
}

// http.service.ts
getAllAppointments(): Observable<any[]> {
  return this.http.get<any[]>(`${this.serverName}/appointments`);
}

reScheduleAppointment(appointmentId: number, updatedAppointment: any): Observable<any> {
  return this.http.put(`${this.serverName}/appointments/${appointmentId}`, updatedAppointment);
}

// http.service.ts
getAppointmentByPatient(patientId: number): Observable<any> {
  return this.http.get(`${this.serverName}/appointments/patient/${patientId}`);
}

// http.service.ts
updateDoctorAvailability(doctorId: number, availability: string): Observable<any> {
  return this.http.put(`${this.serverName}/doctors/${doctorId}/availability`, { availability });
}

// http.service.ts
getAppointmentByDoctor(doctorId: number): Observable<any> {
  return this.http.get(`${this.serverName}/appointments/doctor/${doctorId}`);
}

  // http.service.ts
Login(credentials: { username: string; password: string }): Observable<any> {
  return this.http.post(`${this.serverName}/login`, credentials);
}

  
}
