package com.ozgurucr.example.student;

import com.ozgurucr.example.school.School;
import org.springframework.stereotype.Service;


@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {

        if(dto == null) {
            throw new NullPointerException("The Student Dto should not be null");
        }

        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentRespondeDto toStudentRespondeDto(Student student) {
        return new StudentRespondeDto(student.getFirstName(), student.getLastName(), student.getEmail());

    }
}
