import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../model/payment.model'; // Adjust the path as per your project structure

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) { }

  // Base URL for Payment API
  baseURL: string = 'http://localhost:7373/api/payments'; // Ensure it matches your backend

  // Get all payments
  getAll(): Observable<Payment[]> {
    return this.http.get<Payment[]>(`${this.baseURL}/getall`);
  }

  // Add a new payment
  insert(body: Payment): Observable<Payment> {
    console.log("Adding Payment:", body);
    return this.http.post<Payment>(`${this.baseURL}/add`, body);
  }

  // Update an existing payment
  update(body: Payment): Observable<Payment> {
    console.log("Updating Payment:", body);
    return this.http.put<Payment>(`${this.baseURL}/update`, body);
  }

  // Delete a payment by ID
  delete(paymentId: number): Observable<any> {
    console.log("Deleting Payment with ID:", paymentId);
    return this.http.delete(`${this.baseURL}/deletebyId/${paymentId}`, {
      responseType: 'text'
    });
  }

  // Find a payment by ID
  find(paymentId: number): Observable<Payment> {
    console.log("Finding Payment with ID:", paymentId);
    return this.http.get<Payment>(`${this.baseURL}/getbyid/${paymentId}`);
  }
}
