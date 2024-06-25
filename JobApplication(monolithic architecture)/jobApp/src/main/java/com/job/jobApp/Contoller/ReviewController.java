package com.job.jobApp.Contoller;

import com.job.jobApp.Model.Review;
import com.job.jobApp.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController
{
    @Autowired
    ReviewService reviewService;

    @GetMapping("review")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {
        return reviewService.getAllReviews(companyId);
    }
    @PostMapping("review")
    public ResponseEntity<String> addReviews(@PathVariable Long companyId,@RequestBody Review review)
    {
        return reviewService.addReviews(companyId, review);
    }
    @GetMapping("review/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId)
    {
        return reviewService.getReviewById(companyId,reviewId);
    }
    @PutMapping("review/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review updatedReview)
    {
        return reviewService.updateReviewById(companyId,reviewId,updatedReview);
    }
    @DeleteMapping("review/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId,@PathVariable Long reviewId)
    {
        return reviewService.deleteReviewById(companyId,reviewId);
    }

}
