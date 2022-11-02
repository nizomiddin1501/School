package uz.developers.school.service;

import uz.developers.school.entity.Subject;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects();

    Subject getSubject(Integer id);

    ApiResponce addSubject(SubjectDto subjectDto);

    ApiResponce editSubject(Integer id, SubjectDto subjectDto);

    ApiResponce deleteSubject(Integer id);
}
