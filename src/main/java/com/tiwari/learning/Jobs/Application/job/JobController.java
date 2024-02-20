package com.tiwari.learning.Jobs.Application.job;



import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
public class JobController {
    private JobService jobService ;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Kutte !!";
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String create(@RequestBody Job job){
        jobService.createJob(job);
        return "JOB ADDED!";
    }
    @GetMapping({"/jobs/{id}"})
    public Job getById(@PathVariable Long id){
        if (!Objects.equals(jobService.getById(id), null)) {
            return jobService.getById(id);
        }
        return jobService.defaultJob();
    }
}
