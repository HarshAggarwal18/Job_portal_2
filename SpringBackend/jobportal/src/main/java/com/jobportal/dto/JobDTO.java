package com.jobportal.dto;

import com.jobportal.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
        private Long id;
        private String jobTitle;
        private String company;
        private List<ApplicantDTO> applicants;
        private String about;
        private String experiences;
        private String jobType;
        private String location;
        private Long packageOffered;
        private LocalDateTime postTime;
        private String description;
        private List<String> skillsRequired;
        private JobStatus jobStatus;

    public Job toEntity() {
        return new Job(
                this.id,
                this.jobTitle,
                this.company,
                this.applicants != null ? this.applicants.stream()
                        .map((x)->x.toEntity()) // Correctly map to entities
                        .toList() // Collect to a list
                        : null,
                this.about,
                this.experiences,
                this.jobType,
                this.location,
                this.packageOffered,
                this.postTime,
                this.description,
                this.skillsRequired,
                this.jobStatus
        );
    }

}
