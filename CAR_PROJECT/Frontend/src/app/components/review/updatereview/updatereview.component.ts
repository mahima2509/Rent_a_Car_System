import { Component } from '@angular/core';
import { Review } from 'src/app/model/review.model'; // Update the import to refer to the Review model
import { ReviewService } from 'src/app/services/review.service'; // Update the service reference to ReviewService

@Component({
  selector: 'app-updatereview', // Update the selector to reflect review context
  templateUrl: './updatereview.component.html', // Update the template file name
  styleUrls: ['./updatereview.component.css'] // Update the style file name
})
export class UpdateReviewComponent { // Change class name to UpdateReviewComponent

  constructor(private reviewService: ReviewService) {} // Change to ReviewService

  updateReview(data: Review) { // Change parameter type to Review
    this.reviewService.update(data) // Use ReviewService for updating
      .subscribe(
        (review) => { 
          console.log('Updated Review is: ', review);
          alert('Review updated successfully!'); // Update alert message
        },
        (error) => {
          console.error('Error updating review: ', error);
          alert('Failed to update review. Please try again.'); // Handle error
        }
      );
  }
}
