package com.job.jobApp.Service;

import com.job.jobApp.Model.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService
{

    ResponseEntity<List<Review>> getAllReviews(Long companyId);

    ResponseEntity<String> addReviews(Long companyId,Review review);

    ResponseEntity<Review> getReviewById(Long companyId, Long reviewId);

    ResponseEntity<String> updateReviewById(Long companyId, Long reviewId, Review updatedReview);

    ResponseEntity<String> deleteReviewById(Long companyId, Long reviewId);
}
