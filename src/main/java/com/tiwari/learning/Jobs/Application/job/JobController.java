package com.tiwari.learning.Jobs.Application.job;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
public class JobController {

    private final JobService jobService ;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/hello") // GET/hello : for checking the response
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello Up And Running !!", HttpStatus.OK);
    }

    @GetMapping("/jobs")  // GET/jobs : list of all jobs
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")  // POST/jobs : create job entity
    public ResponseEntity<Job> create(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>(job,HttpStatus.CREATED);
    }
    @GetMapping({"/jobs/{id}"})  // GET/jobs/{id} : fetch job by id
    public ResponseEntity<Job> getById(@PathVariable Long id){
        Job job = jobService.getById(id);
        if(job == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job,HttpStatus.OK);

    }
    @DeleteMapping("/jobs/{id}") // DELETE/jobs/{id} : delete job by id
    public ResponseEntity<String> deleteById(@PathVariable Long id){
       boolean deleted = jobService.deleteById(id);
       if(deleted){
           return new ResponseEntity<>("Job Deleted !!", HttpStatus.OK);
       }
       return new ResponseEntity<>("Not Found !",HttpStatus.NOT_FOUND);
    }


    @PutMapping("/jobs/{id}") // PUT/jobs/{id, updatedJob} : update job by id with updatedJob
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateById(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Updated !!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found !!", HttpStatus.NOT_FOUND);
    }
}
