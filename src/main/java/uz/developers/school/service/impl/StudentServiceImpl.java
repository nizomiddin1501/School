package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.school.entity.Student;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.StudentDto;
import uz.developers.school.repository.StudentRepository;
import uz.developers.school.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    @Override
    public Student getStudent(Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        return null;
    }

    @Override
    public ApiResponce addStudent(StudentDto studentDto){
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        studentRepository.save(student);
        return new ApiResponce("Student is added",true);
    }

    @Override
    public ApiResponce editStudent(Integer id, StudentDto studentDto){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return new ApiResponce("Student is not found",false);
        }
        Student student = optionalStudent.get();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        studentRepository.save(student);
        return new ApiResponce("Student is edited",true);

    }

    @Override
    public ApiResponce deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return new ApiResponce("Student is deleted",true);
    }
}
