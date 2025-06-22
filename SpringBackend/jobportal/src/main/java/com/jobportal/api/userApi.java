package com.jobportal.api;

import com.jobportal.dto.LoginDto;
import com.jobportal.dto.ResponseDTO;
import com.jobportal.dto.UserDto;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.UserService;
import jakarta.validation.Valid;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/users")
public class userApi {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto userDto) throws Exception
    {
//        userDto= userService.registerUser(userDto);
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);

    }
    @PostMapping("/changePass")
    public ResponseEntity<ResponseDTO> changePassword(@RequestBody @Valid LoginDto loginDto) throws Exception
    {
        return new ResponseEntity<>(userService.changePassword(loginDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody @Valid LoginDto loginDto) throws Exception
    {
        return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);
    }

    @PostMapping("/sendOtp/{email}")
    public ResponseEntity<ResponseDTO> sendOtp(@PathVariable @Email(message ="{user.email.invalid}") String email) throws Exception
    {
        userService.sendOtp(email);
        return new ResponseEntity<>(new ResponseDTO("Otp sent Sucessfully."), HttpStatus.OK);

    }
    @GetMapping("/verifyOtp/{email}/{otp}")
    public ResponseEntity<ResponseDTO> verifyOtp(@PathVariable  @Email(message ="{user.email.invalid}") String email,
                                                 @PathVariable @Pattern(regexp = "^[0-9]{6}$",message = "{otp.invalid}") String otp) throws JobPortalException
    {
        userService.verifyOtp(email,otp);
        return new ResponseEntity<>(new ResponseDTO("Otp has been Verified."), HttpStatus.OK);
    }

}
