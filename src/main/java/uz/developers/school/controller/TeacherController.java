package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Teacher;
import uz.developers.school.payload.TeacherDto;
import uz.developers.school.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;


    @GetMapping("/teacher")
    public List<Teacher> getTeacher(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    @PostMapping("/teacher")
    public String addTeacher(@RequestBody TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPhoneNumber(teacher.getPhoneNumber());
        teacherRepository.save(teacher);
        return "Teacher is added";
    }

    @PutMapping("/teacher/{id}")
    public String editTeacher(@PathVariable Integer id, @RequestBody TeacherDto teacherDto){
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setFirstName(teacherDto.getFirstName());
            teacher.setLastName(teacherDto.getLastName());
            teacher.setPhoneNumber(teacher.getPhoneNumber());
            teacherRepository.save(teacher);
            return "Teacher is edited";
        }
        return "Teacher is not found";
    }
    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable Integer id){
        teacherRepository.deleteById(id);
        return "Teacher is deleted";
    }
}
