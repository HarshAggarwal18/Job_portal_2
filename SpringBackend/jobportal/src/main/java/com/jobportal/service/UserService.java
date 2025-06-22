package com.jobportal.service;

import com.jobportal.dto.LoginDto;
import com.jobportal.dto.ResponseDTO;
import com.jobportal.dto.UserDto;
import com.jobportal.exception.JobPortalException;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

public interface UserService {
    UserDto registerUser(UserDto userDto) throws Exception;

    UserDto loginUser( LoginDto loginDto) throws JobPortalException;

    Boolean sendOtp(String email) throws Exception;

    Boolean verifyOtp(String email ,String otp) throws JobPortalException;

    ResponseDTO changePassword( LoginDto loginDto) throws JobPortalException;
}
