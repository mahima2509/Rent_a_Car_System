import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from '../model/driver.model'; // Update the import to Driver model

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  constructor(private http: HttpClient) { }

  // Update the base URL for Driver API
  baseURL: string = 'http://localhost:8282/api/drivers'; // Ensure the URL matches your backend API

  getAll(): Observable<Driver[]> {
    return this.http.get<Driver[]>(`${this.baseURL}/getall`); // Get all drivers
  }

  insert(body: Driver): Observable<Driver> {
    console.log(body);
    return this.http.post<Driver>(`${this.baseURL}/add`, body); // Add a new driver
  }

  update(body: Driver): Observable<Driver> {
    console.log(body);
    return this.http.put<Driver>(`${this.baseURL}/update`, body); // Update an existing driver
  }

  
  //delete(driverId: number): Observable<String> {

  //  return this.http.delete<String>(`${this.baseURL}/deletebyid/${driverId}`); // Delete driver by ID
 // }

  find(driverId: number): Observable<Driver> {
    console.log("service " + driverId);
    return this.http.get<Driver>(`${this.baseURL}/getbyid/${driverId}`); // Find driver by ID
  }
  // DELETE request to delete a cab by ID
  delete(driverId: number): Observable<any> {
    console.log("Deleting Driver with ID:", driverId);
    return this.http.delete(`${this.baseURL}/deletebyid/${driverId}`, {
      responseType: 'text' // Ensure response is treated as plain text
    });
  }
}
