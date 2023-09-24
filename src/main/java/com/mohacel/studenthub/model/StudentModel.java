package com.mohacel.studenthub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
    @Id
    private String id;
    private String academicId;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private LocalDate dateOfBirth;
}
