package com.job.jobApp.Service.impl;

import com.job.jobApp.Model.Company;
import com.job.jobApp.Model.Review;
import com.job.jobApp.Repository.ReviewRepository;
import com.job.jobApp.Service.CompanyService;
import com.job.jobApp.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService
{
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    private CompanyService companyService;

    @Override
    public ResponseEntity<List<Review>> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addReviews(Long companyId,Review review) {
        Company company = companyService.getByIdCompany(companyId).getBody();
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return new ResponseEntity<>("review added",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("no company available",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Review> getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        for(Review review:reviews)
        {
            if(review.getId().equals(reviewId))
            {
                return new ResponseEntity<>(review,HttpStatus.OK);
            }
        }

        //reviews.stream().filter(review->review.getId().equals(reviewId)).findFirst().orElse(null);

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updateReviewById(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getByIdCompany(companyId)!=null)
        {
            updatedReview.setCompany(companyService.getByIdCompany(companyId).getBody());
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return new ResponseEntity<>("Review Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteReviewById(Long companyId, Long reviewId) {
        if(companyService.getByIdCompany(companyId)!=null&& reviewRepository.existsById(reviewId))
        {
            Review review = reviewRepository.findById(reviewId).get();
            review.setCompany(companyService.getByIdCompany(companyId).getBody());
            review.setId(reviewId);
            reviewRepository.delete(review);
            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Deleted",HttpStatus.NOT_FOUND);
    }
}
