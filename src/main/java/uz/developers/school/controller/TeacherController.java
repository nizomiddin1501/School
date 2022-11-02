package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.Teacher;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.TeacherDto;
import uz.developers.school.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers() {
        List<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(teachers);
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Integer id) {
        return teacherService.getTeacher(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addTeacher(@RequestBody TeacherDto teacherDto) {
        ApiResponce apiResponce = teacherService.addTeacher(teacherDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editTeacher(@PathVariable Integer id, @RequestBody TeacherDto teacherDto) {
        ApiResponce apiResponce = teacherService.editTeacher(id,teacherDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        ApiResponce apiResponce = teacherService.deleteTeacher(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
