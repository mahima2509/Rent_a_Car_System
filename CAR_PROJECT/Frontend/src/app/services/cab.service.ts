import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cab, CabDetails } from '../model/cab.model';

@Injectable({
  providedIn: 'root'
})
export class CabService {

  constructor(private http: HttpClient) { }

  // Update the base URL for Cab API
  baseURL: string = 'http://localhost:8181/api/cabs'; // Ensure the URL matches your backend API

  getAll(): Observable<CabDetails[]> {
    return this.http.get<CabDetails[]>(`${this.baseURL}/getall`); // Get all cabs
  }

  insert(body: Cab): Observable<Cab> {
    console.log('Inserting cab:', body);
    return this.http.post<Cab>(`${this.baseURL}/add`, body); // Add a new cab
  }

  update(body: Cab): Observable<Cab> {
    console.log('Updating cab:', body);
    return this.http.put<Cab>(`${this.baseURL}/update/driver-by-cab`, body); // Update an existing cab
  }

  find(cabId: number): Observable<Cab> {
    console.log("Finding cab with ID:", cabId);
    return this.http.get<Cab>(`${this.baseURL}/getbyid/${cabId}`); // Find cab by ID
  }

  // DELETE request to delete a cab by ID
  delete(cabId: number): Observable<any> {
    console.log("Deleting cab with ID:", cabId);
    return this.http.delete(`${this.baseURL}/deletebyid/${cabId}`, {
      responseType: 'text' // Ensure response is treated as plain text
    });
  }
}
