package com.jobportal.api;

import com.jobportal.dto.*;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/jobs")
public class JobAPI {
    @Autowired
    private JobService jobService;

    @PostMapping("/post")
    public ResponseEntity<JobDTO> postJob(@RequestBody @Valid JobDTO jobDto) throws Exception
    {
//        userDto= userService.registerUser(userDto);
        return new ResponseEntity<>(jobService.postJob(jobDto), HttpStatus.CREATED);

    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<JobDTO>> getAllJobs() throws JobPortalException{
        return new ResponseEntity<>(jobService.getAlljobs(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public  ResponseEntity<JobDTO> getAllJob(@PathVariable Long id) throws JobPortalException{
        return new ResponseEntity<>(jobService.getJob(id),HttpStatus.OK);
    }

//    @PostMapping("/apply/{id")
//    public ResponseEntity<ResponseDTO> applyJob(@PathVariable Long id,@RequestBody ApplicantDTO applicantDTO) throws Exception
//    {
//        JobService.applyJob(id,applicantDTO);
//        return new ResponseEntity<>(new ResponseDTO("Applied SucessFully"), HttpStatus.CREATED);
//
//    }
}
