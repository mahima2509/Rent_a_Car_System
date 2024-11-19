import { Component } from '@angular/core';
import { Review } from 'src/app/model/review.model'; // Import the Review model
import { ReviewService } from 'src/app/services/review.service'; // Import the Review service

@Component({
  selector: 'app-addreview', // Selector updated for the review context
  templateUrl: './addreview.component.html', // Update template URL for review component
  styleUrls: ['./addreview.component.css'] // Update style URL if necessary
})
export class AddReviewComponent {

  constructor(private reviewService: ReviewService) {} // Inject ReviewService

  insertReview(data: Review) { // Change parameter type to Review
    this.reviewService.insert(data) // Call the insert method from ReviewService
      .subscribe(
        (review) => {
          console.log('Added Review is: ', review); // Log the added review
          alert('Review added successfully!'); // Success message
        },
        (error) => {
          console.error('Error adding review: ', error); // Handle errors
          alert('Failed to add review. Please try again.'); // Error message
        }
      );
  }
}
