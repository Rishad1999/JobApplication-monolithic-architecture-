package com.job.jobApp.Service;

import com.job.jobApp.Model.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {
    ResponseEntity<List<Company>> getAllCompanies();

    ResponseEntity<String> updateCompany(Long id, Company updatedCompany);

    ResponseEntity<String> createCompany(Company company);

    ResponseEntity<String> deleteCompany(Long id);

    ResponseEntity<Company> getByIdCompany(Long id);
}
