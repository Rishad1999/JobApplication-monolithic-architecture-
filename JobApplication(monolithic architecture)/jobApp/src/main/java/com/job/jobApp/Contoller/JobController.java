package com.job.jobApp.Contoller;

import com.job.jobApp.Model.Job;
import com.job.jobApp.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController
{
    @Autowired
    private JobService jobService;


    @GetMapping
    public ResponseEntity<List<Job>> findAllJobs()
    {
        return jobService.findAllJobs();
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        return jobService.createJob(job);
    }

    @GetMapping("{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id)
    {
        return jobService.findJobById(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id)
    {
        return jobService.deleteJobById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updatebyId(@PathVariable Long id,@RequestBody Job updatedjob){ return jobService.updatebyId(id,updatedjob);}
}
