package com.jobportal.entity;

import com.jobportal.dto.AccountType;
import com.jobportal.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "users")
public class User {
    @Id
    private Long id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String password;
    private AccountType accountType;

    //for profile
    private Long profileId;

    public UserDto toDto(){
        return new UserDto(this.id,this.name,this.email,this.password,this.accountType,this.profileId);
    }
}
