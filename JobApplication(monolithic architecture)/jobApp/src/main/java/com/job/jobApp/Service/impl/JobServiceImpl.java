package com.job.jobApp.Service.impl;

import com.job.jobApp.Model.Job;
import com.job.jobApp.Repository.JobRepository;
import com.job.jobApp.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService
{
    @Autowired
    JobRepository jobRepository;
    //public List<Job> jobs = new ArrayList<>();
    @Override
    public ResponseEntity<List<Job>> findAllJobs() {
        return new ResponseEntity<>(jobRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createJob(Job job) {
        jobRepository.save(job);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Job> findJobById(Long id) {
        if(jobRepository.existsById(id))
        {
            jobRepository.deleteById(id);
            return new ResponseEntity<>(jobRepository.findById(id).orElse(null), HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteJobById(Long id)
    {
//        for(Job job : jobs)
//        {
//            if(job.getId().equals(id))
//            {
//                jobs.remove(job);
//                return new ResponseEntity<>("Deleted", HttpStatus.OK);
//            }
//        }
        if(jobRepository.existsById(id))
        {
            jobRepository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Deleted", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updatebyId(Long id,Job updatedjob) {

        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent())
        {
            Job job = jobOptional.get();
            job.setDescription(updatedjob.getDescription());
            job.setTitle(updatedjob.getTitle());
            job.setMinSalary(updatedjob.getMinSalary());
            job.setMaxSalary(updatedjob.getMaxSalary());
            job.setLocation(updatedjob.getLocation());
            jobRepository.save(job);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);

//        Iterator<Job> iterator=jobs.iterator();
//        while(iterator.hasNext())
//        {
//            Job job = iterator.next();
//            if(job.getId().equals(id))
//            {
//                job.setDescription(updatedjob.getDescription());
//                job.setTitle(updatedjob.getTitle());
//                job.setMinSalary(updatedjob.getMinSalary());
//                job.setMaxSalary(updatedjob.getMaxSalary());
//                job.setLocation(updatedjob.getLocation());
//
//                return new ResponseEntity<>("Success",HttpStatus.CREATED);
//            }
//        }
//        return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
    }
}
