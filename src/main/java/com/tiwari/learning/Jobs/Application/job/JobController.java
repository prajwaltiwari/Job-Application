package com.tiwari.learning.Jobs.Application.job;


import com.tiwari.learning.Jobs.Application.job.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class JobController {
    private JobServiceImp jobServiceImp ;
    @GetMapping("/hello")
    public String hello(){
        return "Hello Kutte !!";
    }
    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobServiceImp.findAll();
    }

    @PostMapping("/jobs")
    public String create(@RequestBody Job job){
        jobServiceImp.createJob(job);
        return "JOB ADDED! ";
    }
}
