package com.mohacel.studenthub.repository;

import com.mohacel.studenthub.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<StudentModel,String> {
    @Query("{'academicId': ?0}")
    List<StudentModel> findByAcademicId(String academicId);
}
