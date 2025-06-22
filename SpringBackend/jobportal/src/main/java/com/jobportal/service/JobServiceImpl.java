package com.jobportal.service;

import com.jobportal.dto.ApplicantDTO;
import com.jobportal.dto.ApplicantStatus;
import com.jobportal.dto.JobDTO;
import com.jobportal.entity.Applicant;
import com.jobportal.entity.Job;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.JobRepository;
import com.jobportal.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

//    @Override
//    public void applyJob(Long id, ApplicantDTO applicantDTO) throws JobPortalException {
//        Job job = jobRepository.findById(id).orElseThrow(()->new JobPortalException(("JOB_NOT_FOUND")));
//        List<Applicant>applicants = job.getApplicants();
//        if(applicants==null)applicants=new ArrayList<>();
//        if(applicants.stream().filter((x)->x.getApplicantId()==applicantDTO.getApplicantId()).toList().size()>0)throw new JobPortalException("Job_APPLIED_ALREADY");
//        applicantDTO.setApplicantStatus(ApplicantStatus.APPLIED);
//        applicants.add(applicantDTO.toEntity());
//        jobRepository.save(job);
//
//    }

    @Override
    public JobDTO postJob(JobDTO jobDTO) throws Exception {
      jobDTO.setId((Utilities.getNextSequence("jobs")));
        jobDTO.setPostTime(LocalDateTime.now());
        return  jobRepository.save(jobDTO.toEntity()).toDTO();
    }

    @Override
    public List<JobDTO> getAlljobs() {
        return  jobRepository.findAll().stream().map((x)->x.toDTO()).toList();
        // we find all job convert it into Dto then make list of all this jobs
    }

    @Override
    public JobDTO getJob(Long id) throws JobPortalException {
        return jobRepository.findById(id).orElseThrow(()-> new JobPortalException("JOB_NOT_FOUND")).toDTO();
    }


}
