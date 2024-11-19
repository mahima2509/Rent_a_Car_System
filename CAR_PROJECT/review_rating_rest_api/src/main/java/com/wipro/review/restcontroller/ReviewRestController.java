package com.wipro.review.restcontroller;

import java.util.List;

import com.wipro.review.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.review.dto.ReviewDTO;
import com.wipro.review.entity.Review;
import com.wipro.review.service.IReviewService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/reviews")
public class ReviewRestController {

    @Autowired
    private IReviewService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private boolean authenticate(HttpServletRequest request) {
        // Get the Authorization header from the request
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token from the header
            String token = authHeader.substring(7); // Remove "Bearer " prefix

            // Validate the token
            return jwtTokenUtil.validateToken(token);
        }

        return false; // Token is not present or invalid
    }

    @PostMapping("/add")
    public Review addReview(@RequestBody ReviewDTO reviewDTO,HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.addReview(reviewDTO);
    }

    @GetMapping("/get/{reviewId}")
    public ReviewDTO getReviewById(@PathVariable int reviewId,HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.getById(reviewId);
    }

    @GetMapping("/getall")
    public List<Review> getAllReviews(HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.getAllReviews();
    }

    @PutMapping("/update")
    public Review updateReview(@RequestBody ReviewDTO reviewDTO,HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.updateReview(reviewDTO);
    }

	/*
	 * @DeleteMapping("/deletebyid/{reviewId}") public ResponseEntity<String>
	 * deleteReviewById(@PathVariable int reviewId) { service.deletebyId(reviewId);
	 * return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK); }
	 */
    
    @DeleteMapping(value = "/deletebyId/{reviewId}")
    public String deleteReviewById(@PathVariable int reviewId,HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        service.deleteById(reviewId);
        return "Review with ID " + reviewId + " deleted successfully.";
    }
}
