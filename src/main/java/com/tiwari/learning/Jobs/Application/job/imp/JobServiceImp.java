package com.tiwari.learning.Jobs.Application.job.imp;

import com.tiwari.learning.Jobs.Application.job.Job;
import com.tiwari.learning.Jobs.Application.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImp implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId =1l;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getById(Long id) {
        for (Job job: jobs) {
            if(Objects.equals(job.getId(), id))
                return job;
        }
        return null;
    }

    @Override
    public Job defaultJob() {
        return new Job();
    }
}
