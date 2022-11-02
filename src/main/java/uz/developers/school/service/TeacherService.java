package uz.developers.school.service;

import uz.developers.school.entity.Teacher;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.TeacherDto;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();

    Teacher getTeacher(Integer id);

    ApiResponce addTeacher(TeacherDto teacherDto);

    ApiResponce editTeacher(Integer id, TeacherDto teacherDto);

    ApiResponce deleteTeacher(Integer id);

}
