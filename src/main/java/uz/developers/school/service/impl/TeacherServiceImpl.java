package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.school.entity.Teacher;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.TeacherDto;
import uz.developers.school.repository.TeacherRepository;
import uz.developers.school.service.TeacherService;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();

    }

    @Override
    public Teacher getTeacher(Integer id){
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            return optionalTeacher.get();
        }
        return null;
    }

    @Override
    public ApiResponce addTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPhoneNumber(teacher.getPhoneNumber());
        teacherRepository.save(teacher);
        return new ApiResponce("Teacher is added", true);
    }

    @Override
    public ApiResponce editTeacher(Integer id, TeacherDto teacherDto) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isEmpty()) {
            return new ApiResponce("Teacher is not found", false);
        }
        Teacher teacher = optionalTeacher.get();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPhoneNumber(teacher.getPhoneNumber());
        teacherRepository.save(teacher);
        return new ApiResponce("Teacher is edited", true);
    }

    @Override
    public ApiResponce deleteTeacher( Integer id) {
        teacherRepository.deleteById(id);
        return new ApiResponce("Teacher is deleted",true);
    }
}
