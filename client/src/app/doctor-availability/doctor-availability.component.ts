import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpService } from '../../services/http.service';

@Component({
  selector: 'app-doctor-availability',
  templateUrl: './doctor-availability.component.html',
  styleUrls: ['./doctor-availability.component.scss']
})
export class DoctorAvailabilityComponent //todo: complete missing code..
{
  itemForm: FormGroup;
  formModel: any = {};
  responseMessage: any;
  isAdded: boolean = false;

  constructor(public httpService: HttpService, private formBuilder: FormBuilder) {
    this.itemForm = this.formBuilder.group({
      doctorId: ['', Validators.required],
      availability: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    // Initialization logic can be added here if needed
  }

  onSubmit() {
    const userIdString = localStorage.getItem('userId');
    const doctorId = userIdString ? parseInt(userIdString, 10) : null;

    if (doctorId !== null) {
      this.itemForm.controls['doctorId'].setValue(doctorId);
      const availability = this.itemForm.controls['availability'].value;

      this.httpService.updateDoctorAvailability(doctorId, availability).subscribe(
        response => {
          this.isAdded = true;
          this.responseMessage = response;
          this.itemForm.reset();
        },
        error => {
          console.error('Error updating availability:', error);
        }
      );
    } else {
      console.error('User ID not found in local storage.');
    }
  }
}