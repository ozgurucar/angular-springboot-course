package com.ozgurucr.example.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }


    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "john.doe@test.com",
                1
        );

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());


    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        //  Given
        Student student = new Student("Agent", "Smith", "agent.smith@observer.com", 32);

        //  When
        StudentRespondeDto response = mapper.toStudentRespondeDto(student);

        //  Then
        assertEquals(response.firstName(), student.getFirstName());
        assertEquals(response.lastName(), student.getLastName());
        assertEquals(response.email(), student.getEmail());

    }

    @Test
    public void should_throw_null_pointer_exception_studentDto_to_student_when_studentDto_is_null() {
        var msg = assertThrows(NullPointerException.class,() -> mapper.toStudent(null));
        assertEquals("The Student Dto should not be null", msg.getMessage());
    }
}