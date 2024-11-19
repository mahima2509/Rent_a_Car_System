import { Component } from '@angular/core';
import { AuthService } from 'src/app/auth.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  signupForm = {
    username: '',
    password: '',
    address: '',
    email: '',
    roles: ''
  };

  constructor(private authService: AuthService) {}

  signup(): void {
    this.authService.signup(this.signupForm);
  }
}
