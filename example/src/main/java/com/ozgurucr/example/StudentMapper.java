package com.ozgurucr.example;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {
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
