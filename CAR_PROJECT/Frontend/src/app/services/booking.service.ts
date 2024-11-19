import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking.model'; // Adjust the path as per your project structure

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }

  // Base URL for Booking API
  baseURL: string = 'http://localhost:7272/api/bookings'; // Ensure it matches your backend

  // Get all bookings
  getAll(): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.baseURL}/getall`);
  }

  // Add a new booking
  insert(body: Booking): Observable<Booking> {
    console.log("Adding Booking:", body);
    return this.http.post<Booking>(`${this.baseURL}/add`, body);
  }

  // Update an existing booking
  update(body: Booking): Observable<Booking> {
    console.log("Updating Booking:", body);
    return this.http.put<Booking>(`${this.baseURL}/update`, body);
  }

  // Delete a booking by ID
  delete(bookingId: number): Observable<any> {
    console.log("Deleting Booking with ID:", bookingId);
    return this.http.delete(`${this.baseURL}/deletebyid/${bookingId}`, {
      responseType: 'text'
    });
  }

  // Find a booking by ID
  find(bookingId: number): Observable<Booking> {
    console.log("Finding Booking with ID:", bookingId);
    return this.http.get<Booking>(`${this.baseURL}/getbyid/${bookingId}`);
  }
}
