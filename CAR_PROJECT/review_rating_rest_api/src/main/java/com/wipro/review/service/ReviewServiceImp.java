package com.wipro.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.wipro.payment.entity.Payment;
import com.wipro.review.dto.ReviewDTO;
import com.wipro.review.entity.Review;
import com.wipro.review.repository.ReviewRepository;

@Service
public class ReviewServiceImp implements IReviewService {

    @Autowired
    private ReviewRepository repo;

    @Override
    public Review addReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setCustomerName(reviewDTO.getCustomerName());
        review.setDriverName(reviewDTO.getDriverName());
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());
        return repo.save(review);
    }

    @Override
    public ReviewDTO getById(int reviewId) {
        Review review = repo.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setCustomerName(review.getCustomerName());
        reviewDTO.setDriverName(review.getDriverName());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComments(review.getComments());
        
        return reviewDTO;
    }

    @Override
    public List<Review> getAllReviews() {
        return repo.findAll();
    }

    @Override
    public Review updateReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewId(reviewDTO.getReviewId());
        review.setCustomerName(reviewDTO.getCustomerName());
        review.setDriverName(reviewDTO.getDriverName());
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());
        return repo.save(review);
    }

    
    @Override
	public void deleteById(int reviewId) {
	    Review review = repo.findById(reviewId)
	                  .orElseThrow(() -> new RuntimeException("Review with ID " + reviewId + " not found."));
	    repo.delete(review);  // Delete the cab from the repository
	    System.out.println("Review with ID " + reviewId + " deleted successfully.");
	}



	
}
