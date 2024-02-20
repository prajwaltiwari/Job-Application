package com.tiwari.learning.Jobs.Application.job;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;


@RestController
public class JobController {

    private final JobService jobService ;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Up And Running !!";
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> create(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>(job,HttpStatus.CREATED);
    }
    @GetMapping({"/jobs/{id}"})
    public ResponseEntity<Job> getById(@PathVariable Long id){
        Job job = jobService.getById(id);
        if(job == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job,HttpStatus.OK);

    }
}
