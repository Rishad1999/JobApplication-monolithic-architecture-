package com.job.jobApp.Service;

import com.job.jobApp.Model.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface JobService {

    ResponseEntity<List<Job>> findAllJobs();

    ResponseEntity<String> createJob(Job job);

    ResponseEntity<Job> findJobById(Long id);

    ResponseEntity<String> deleteJobById(Long id);

    ResponseEntity<String> updatebyId(Long id, Job updatedjob);
}
