import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../model/review.model'; // Adjust the path as needed

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }

  // Base URL for Review API
  baseURL: string = 'http://localhost:7474/api/reviews'; // Ensure it matches your backend

  // Get all reviews
  getAll(): Observable<Review[]> {
    return this.http.get<Review[]>(`${this.baseURL}/getall`);
  }

  // Add a new review
  insert(body: Review): Observable<Review> {
    console.log("Adding Review:", body);
    return this.http.post<Review>(`${this.baseURL}/add`, body);
  }

  // Update an existing review
  update(body: Review): Observable<Review> {
    console.log("Updating Review:", body);
    return this.http.put<Review>(`${this.baseURL}/update`, body);
  }

  // Delete a review by ID
  delete(reviewId: number): Observable<any> {
    console.log("Deleting Review with ID:", reviewId);
    return this.http.delete(`${this.baseURL}/deletebyId/${reviewId}`, {
      responseType: 'text'
    });
  }

  // Find a review by ID
  find(reviewId: number): Observable<Review> {
    console.log("Finding Review with ID:", reviewId);
    return this.http.get<Review>(`${this.baseURL}/getbyid/${reviewId}`);
  }
}
