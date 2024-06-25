package com.job.jobApp.Repository;

import com.job.jobApp.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
