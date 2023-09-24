package com.mohacel.studenthub.controller;

import com.mohacel.studenthub.model.StudentModel;
import com.mohacel.studenthub.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public ResponseEntity<?> register(@RequestBody StudentModel student){
        StudentModel registered = service.register(student);
        return new ResponseEntity<>(registered, HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<?> getStudent(@RequestParam String academicId) {
        try {
            StudentModel student = service.getStudentByAcademicId(academicId);
            if (student != null) {
                logger.info("Student found: {}", student);
                return new ResponseEntity<>(student, HttpStatus.OK);
            } else {
                logger.warn("Student not found for academicId: {}", academicId);
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error while retrieving student by academicId: {}", academicId, e);
            return new ResponseEntity<>("Error occurred while retrieving student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
