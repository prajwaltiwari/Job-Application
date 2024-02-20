package com.tiwari.learning.Jobs.Application.job;

import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getById(Long id);

    Job defaultJob();
}
