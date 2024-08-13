package com.ozgurucr.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentMapper studentMapper;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_save_a_student_successfully() {

        // Given
        StudentDto dto = new StudentDto("John", "Doe", "john.doe@test.com", 1);

        Student student = new Student("John", "Doe", "john.doe@test.com", 20);

        Student savedStudent = new Student("John", "Doe", "john.doe@test.com", 20);
        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentRespondeDto(savedStudent)).thenReturn(new StudentRespondeDto("John", "Doe", "john.doe@test.com"));

        // When
        StudentRespondeDto responseDto = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        // Verify the interactions with mocks
        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentRespondeDto(savedStudent);
    }
}
