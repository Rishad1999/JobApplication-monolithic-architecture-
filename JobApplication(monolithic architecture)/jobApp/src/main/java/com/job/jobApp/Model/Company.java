package com.job.jobApp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore //here the below is infinite so using jsonignore we can get rid of that problem
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;//One company has many jobs

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
}
