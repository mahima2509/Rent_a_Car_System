import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8082/auth'; // Adjust as per your API Gateway

  constructor(private http: HttpClient, private router: Router) { }

  // Signup request
  signup(user: any): void {
    this.http.post(`${this.apiUrl}/signup`, user, { responseType: 'text' }).subscribe({
      next: (response: any) => {
        alert('Signup successful!, Please Login!');
        this.router.navigate(['/login']);
      },
      error: (error: any) => {
        console.error('Signup error:', error);
      }
    });
  }

  // Login request
  login(user: any): void {
    this.http.post(`${this.apiUrl}/login`, user).subscribe({
      next: (response: any) => {
        // Set session on successful login
        this.setSession(response.username, response.token);
        alert('Login successful!');
        // Navigate to dashboard or another route after successful login
        this.router.navigate(['']);
      },
      error: (error: any) => {
        console.error('Login error:', error);
      }
    });
  }

  // Set session in localStorage
  private setSession(username: string, token: string): void {
    localStorage.setItem('username', username);
    localStorage.setItem('token', token);
  }

  // Check if the user is logged in
  isLoggedIn(): boolean {
    return !!localStorage.getItem('token'); // Returns true if the token exists
  }

  // Get the logged-in username
  getUsername(): string | null {
    return localStorage.getItem('username');
  }

  // Get the stored token
  getToken(): string | null {
    return localStorage.getItem('token');
  }

  // Logout user by removing token and username from localStorage
  logout(): void {
    localStorage.removeItem('username');
    localStorage.removeItem('token');
    alert('User Logged out successful!');
    this.router.navigate(['/login']); // Navigate back to the login page after logout
  }

  // Handle errors in HTTP requests
  private handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = 'An unknown error occurred!';
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(() => new Error(errorMessage));
  }
}
