package com.tiwari.learning.Jobs.Application.job.imp;

import com.tiwari.learning.Jobs.Application.job.Job;
import com.tiwari.learning.Jobs.Application.job.JobRepository;
import com.tiwari.learning.Jobs.Application.job.JobService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImp implements JobService {
    //private final List<Job> jobs = new ArrayList<>();
    private final JobRepository jobRepository;

    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
    @Override
    public boolean updateById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;    }
}
