package com.jobportal.dto;


import com.jobportal.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    @NotBlank(message = "{user.name.absent}")
    private String name;
    @NotBlank(message = "{user.email.absent}")
    @Email(message = "{user.email.invalid}")
    private String email;
    @NotBlank(message = "{user.passowrd.absent}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-_=+{};:,<.>]).{8,15}$" , message = "{user.passowrd.invalid}")
    private String password;
    private AccountType accountType;

    //for Ptofile
    private Long profileId;

    public User toEntity(){
        return new User(this.id,this.name,this.email,this.password,this.accountType,this.profileId);
    }
}
