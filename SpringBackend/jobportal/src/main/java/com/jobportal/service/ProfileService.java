package com.jobportal.service;

import com.jobportal.dto.ProfileDTO;
import com.jobportal.exception.JobPortalException;

public interface ProfileService {
     public Long cretateProfile(String email) throws Exception;
     ProfileDTO getProfile(Long id) throws JobPortalException;
     ProfileDTO updateProfile(ProfileDTO profileDTO) throws JobPortalException;
}
