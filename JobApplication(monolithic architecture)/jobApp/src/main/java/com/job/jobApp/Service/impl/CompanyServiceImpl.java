package com.job.jobApp.Service.impl;

import com.job.jobApp.Model.Company;
import com.job.jobApp.Model.Job;
import com.job.jobApp.Repository.CompanyRepository;
import com.job.jobApp.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService
{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createCompany(Company company) {
        companyRepository.save(company);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Company> getByIdCompany(Long id) {
        if(companyRepository.existsById(id))
        {
            return new ResponseEntity<>(companyRepository.findById(id).get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<String> deleteCompany(Long id) {
        if(companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }




    @Override
    public ResponseEntity<String> updateCompany(Long id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent())
        {
            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
    }


}
