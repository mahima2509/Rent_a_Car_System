import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/model/review.model'; // Importing Driver model
import { ReviewService } from 'src/app/services/review.service'; // Importing Driver service

@Component({
  selector: 'app-displayallreview', // Component selector
  templateUrl: './displayallreview.component.html', // HTML template for the component
  styleUrls: ['./displayallreview.component.css'] // Styles for the component
})
export class DisplayAllReviewComponent implements OnInit { // Implement OnInit for lifecycle hooks
  
  reviewList: Review[] = []; // Array to hold the list of drivers

  constructor(private reviewService: ReviewService) {} // Inject DriverService

  ngOnInit() {
    this.getAllReviews(); // Fetch all drivers on component initialization
  }

  getAllReviews() {
    this.reviewService.getAll().subscribe(
      (list) => {
        this.reviewList = list; // Assign fetched drivers to driverList
        console.log('Fetched Reviews:', list); // Log the fetched list for debugging
      },
      (error) => {
        console.error('Error fetching reviews:', error); // Handle errors gracefully
      }
    );
  }

  deleteById(reviewId: number) { // Method to delete a driver by ID
    this.reviewService.delete(reviewId).subscribe(
      (msg) => {
        console.log('Deleted Review:', msg); // Log success message from backend
        this.getAllReviews(); // Refresh the driver list after deletion
      },
      (error) => {
        console.error('Error deleting review:', error); // Log error on failure
      }
    );
  }
}
