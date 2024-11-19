package com.wipro.review.service;

import java.util.List;

import com.wipro.review.dto.ReviewDTO;
import com.wipro.review.entity.Review;

public interface IReviewService {

    public Review addReview(ReviewDTO reviewDTO);
    
    public ReviewDTO getById(int reviewId);
    
    public List<Review> getAllReviews();
    
    public Review updateReview(ReviewDTO reviewDTO);

	//void deletebyId(int reviewId);

	public void deleteById(int reviewId);

	//void deletebyId(int reviewId);

  //  public void deletebyid(int reviewId);

	//void deleteByid(int reviewId);

	//public void deletebyId(int reviewId);

	//void deleteById(int reviewId);
}
