import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent //todo: complete missing code..
{
  itemForm: FormGroup;
  formModel: any = {};
  showError: boolean = false;
  errorMessage: string;

  constructor(
    public router: Router,
    public httpService: HttpService,
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {
    this.itemForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    // Additional initialization logic can be added here if needed
  }

  onLogin() {
    if (this.itemForm.valid) {
      const username = this.itemForm.controls['username'].value;
      const password = this.itemForm.controls['password'].value;

      this.httpService.Login({ username, password }).subscribe(
        (response: any) => {
          // Assume the response contains role, token, and userId
          const { role, token, userId } = response;
          this.authService.saveRole(role);
          this.authService.saveToken(token);
          this.authService.saveUserId(userId);

          this.router.navigate(['/dashboard']).then(() => {
            setTimeout(() => {
              window.location.reload();
            }, 500);
          });
        },
        error => {
          this.showError = true;
          this.errorMessage = 'Invalid username or password. Please try again.';
          console.error('Login error:', error);
        }
      );
    } else {
      this.showError = true;
      this.errorMessage = 'Please fill out all required fields.';
    }
  }

  registration() {
    this.router.navigate(['/registration']);
  }
}

