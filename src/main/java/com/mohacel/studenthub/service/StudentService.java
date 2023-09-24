package com.mohacel.studenthub.service;

import com.mohacel.studenthub.model.StudentModel;
import com.mohacel.studenthub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public StudentModel register(StudentModel student){
        student.setId(String.valueOf(UUID.randomUUID().getMostSignificantBits()).replace("-",""));
        return repository.save(student);
    }

    public StudentModel getStudentByAcademicId(String academicId){
        List<StudentModel> list = repository.findByAcademicId(academicId);
        return list.get(0);
    }
}
