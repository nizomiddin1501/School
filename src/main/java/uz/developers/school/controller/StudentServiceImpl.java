package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Student;
import uz.developers.school.payload.StudentDto;
import uz.developers.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentServiceImpl {


    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/student")
    public List<Student> getStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        studentRepository.save(student);
        return "Student is added";
    }

    @PutMapping("/student/{id}")
    public String editStudent(@PathVariable Integer id,@RequestBody StudentDto studentDto){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(studentDto.getFirstName());
            student.setLastName(studentDto.getLastName());
            student.setPhoneNumber(studentDto.getPhoneNumber());
            studentRepository.save(student);
            return "Student is edited";
        }
        return "Student not found";
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Student is deleted";
    }
}
