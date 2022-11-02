package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.Student;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.StudentDto;
import uz.developers.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(students);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addStudent(@RequestBody StudentDto studentDto) {
        ApiResponce apiResponce = studentService.addStudent(studentDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        ApiResponce apiResponce = studentService.editStudent(id,studentDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        ApiResponce apiResponce = studentService.deleteStudent(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
