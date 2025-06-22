package com.jobportal.service;

import com.jobportal.dto.LoginDto;
import com.jobportal.dto.ResponseDTO;
import com.jobportal.dto.UserDto;
import com.jobportal.entity.OTP;
import com.jobportal.entity.User;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.OTPRepository;
import com.jobportal.repository.UserRepository;
import com.jobportal.utility.Data;
import com.jobportal.utility.Utilities;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service(value = "UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OTPRepository otpRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public UserDto registerUser(UserDto userDto) throws Exception {
        Optional<User> optional=userRepository.findByEmail(userDto.getEmail());
        if (optional.isPresent()) throw new JobPortalException("USER_FOUND");
        userDto.setProfileId(profileService.cretateProfile(userDto.getEmail()));
        userDto.setId(Utilities.getNextSequence("users"));
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userDto.toEntity();
         user=userRepository.save(user);
         return user.toDto();
    }

    @Override
    public UserDto loginUser(LoginDto loginDto) throws JobPortalException {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()-> new JobPortalException("USER_NOT_FOUND"));
        if (! passwordEncoder.matches(loginDto.getPassword(),user.getPassword())) throw new JobPortalException("INVALID_CREDENTIALS");
        return user.toDto();
    }

    @Override
    public Boolean sendOtp(String email) throws Exception {
        userRepository.findByEmail(email).orElseThrow(()-> new JobPortalException("USER_NOT_FOUND"));
        MimeMessage mm = mailSender.createMimeMessage();
        MimeMessageHelper message= new MimeMessageHelper(mm,true);
        message.setTo(email);
        message.setSubject("Your OTP Code");
        String genOtp = Utilities.genrateOTP();
        OTP otp = new OTP(email,genOtp, LocalDateTime.now());
        otpRepository.save(otp);
        message.setText(Data.getMessageBody(email,genOtp,"JOB HOOK"),true);
        mailSender.send(mm);
        return true;
    }

    @Override
    public Boolean verifyOtp(String email,String otp) throws JobPortalException {
        OTP otpentity = otpRepository.findById(email).orElseThrow(()->new JobPortalException("OTP_NOT_FOUND"));
        if(!otpentity.getOtpCode().equals(otp) ) throw new JobPortalException("OTP_INCORRECT");
        return true;
    }

    @Override
    public ResponseDTO changePassword(LoginDto loginDto) throws JobPortalException {
        User user= userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()-> new JobPortalException("USER_NOT_FOUND"));
        user.setPassword(passwordEncoder.encode(loginDto.getPassword()));
        userRepository.save(user);
        return new ResponseDTO("Password Change Sucessfully");
    }

    @Scheduled(fixedRate = 60000)
    public void removedExpiredOtps(){
        LocalDateTime expiry=LocalDateTime.now().minusMinutes(5);
        List<OTP> expiredOtps=otpRepository.findByCreationTimeBefore(expiry);
        if(!expiredOtps.isEmpty()) {
            otpRepository.deleteAll(expiredOtps);
            System.out.println("Removed" + expiredOtps.size() +"expired otps") ;
        }

    }
}
