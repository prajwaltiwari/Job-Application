package com.tiwari.learning.Jobs.Application.job;

import java.util.ArrayList;
import java.util.List;

public class JobServiceImp implements JobService {
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
