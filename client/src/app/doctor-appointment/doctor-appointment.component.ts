import { Component, OnInit } from '@angular/core';
import { HttpService } from '../../services/http.service';

@Component({
  selector: 'app-doctor-appointment',
  templateUrl: './doctor-appointment.component.html',
  styleUrls: ['./doctor-appointment.component.scss']
})
export class DoctorAppointmentComponent implements OnInit{

//todo: complete missing code..
appointmentList: any[] = [];

constructor(public httpService: HttpService) {}

ngOnInit(): void {
  this.getAppointments();
}

getAppointments() {
  const userIdString = localStorage.getItem('userId');
  const userId = parseInt(userIdString, 10);
  this.httpService.getAppointmentByDoctor(userId).subscribe(data => {
    this.appointmentList = data;
    console.log(this.appointmentList);
  });
}
}