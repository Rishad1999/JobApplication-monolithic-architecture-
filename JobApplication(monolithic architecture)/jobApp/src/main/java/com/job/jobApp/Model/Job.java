package com.job.jobApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
//@Table(name = "job_table")
public class Job
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer minSalary;

    private Integer maxSalary;
    private String location;

    @ManyToOne
    private Company company;


}
