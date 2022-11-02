package uz.developers.school.service;

import uz.developers.school.entity.Student;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.StudentDto;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(Integer id);

    ApiResponce addStudent(StudentDto studentDto);

    ApiResponce editStudent(Integer id, StudentDto studentDto);

    ApiResponce deleteStudent(Integer id);
}
