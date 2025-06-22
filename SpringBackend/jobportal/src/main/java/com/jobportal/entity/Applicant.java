package com.jobportal.entity;
import com.jobportal.dto.ApplicantDTO;
import com.jobportal.dto.ApplicantStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import org.springframework.data.mongodb.core.mapping.Document; // Uncomment if using MongoDB
import java.time.LocalDateTime;
import java.util.Base64;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document // Uncomment if using MongoDB
public class Applicant {
    private Long applicantId;
    private String name;
    private String email;
    private Long phone;
    private String website;
    private byte[] resume;
    private String coverLetter;
    private LocalDateTime timestamp;
    private ApplicantStatus applicantStatus;
    public ApplicantDTO toDTO() {
        return new ApplicantDTO(
                this.applicantId,
                this.name,
                this.email,
                this.phone,
                this.website,
                this.resume!=null ? Base64.getEncoder().encodeToString(this.resume):null,
                this.coverLetter,
                this.timestamp,
                this.applicantStatus // Removed the extra comma
        );
    }
}