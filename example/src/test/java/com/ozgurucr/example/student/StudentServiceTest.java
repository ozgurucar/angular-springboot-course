package com.ozgurucr.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void should_return_all_students() {

        //  Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "john.doe@glock.com", 20));
        //  Mock The Calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentRespondeDto(any(Student.class))).thenReturn(new StudentRespondeDto("John", "Doe", "john.doe@test.com"));

        //  When
        List<StudentRespondeDto> respondeDtos = studentService.getAllStudents();

        //  Then
        assertEquals(students.size() ,respondeDtos.size());
    }

    @Test
    public void should_return_a_student_by_id() {
        //Given
        Student student = new Student("John", "Doe", "john.doe@test.com", 20);
        student.setId(1);

        //Mock The Calls
        when(studentRepository.findById(1)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentRespondeDto(any(Student.class))).thenReturn(new StudentRespondeDto("John", "Doe", "john.doe@test.com"));

        //When
        StudentRespondeDto dto = studentService.getStudentById(1);

        //Then
        assertEquals(student.getFirstName(), dto.firstName());
        assertEquals(student.getLastName(), dto.lastName());
        assertEquals(student.getEmail(), dto.email());

        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    public void should_find_student_by_name() {

        //Given
        String name = "John";
       List<Student> students = new ArrayList<>();

       students.add(new Student("John", "Doe", "john.doe@test.com", 20));


        //Mock The Calls

        when(studentRepository.findAllByFirstNameContaining(name)).thenReturn(students);
        when(studentMapper.toStudentRespondeDto(any(Student.class))).thenReturn(new StudentRespondeDto("John", "Doe", "john.doe@test.com"));
        //When
        var responseDto = studentService.getStudentsByName(name);

        //Then
        assertEquals(responseDto.size() , students.size());
        verify(studentRepository, times(1)).findAllByFirstNameContaining(name);
    }

}
