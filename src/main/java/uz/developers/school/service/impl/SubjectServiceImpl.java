package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.school.entity.Subject;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.SubjectDto;
import uz.developers.school.repository.SubjectRepository;
import uz.developers.school.service.SubjectService;

import java.util.List;
import java.util.Optional;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public List<Subject> getSubjects(){
       return subjectRepository.findAll();

    }
    @Override
    public Subject getSubject(Integer id){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            return optionalSubject.get();
        }
        return null;
    }
    @Override
    public ApiResponce addSubject(SubjectDto subjectDto){
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
        return new ApiResponce("Subject is added",true);
    }

    @Override
    public ApiResponce editSubject(Integer id, SubjectDto subjectDto){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty()) {

            return new ApiResponce("Subject is not found",false);
        }
        Subject subject = optionalSubject.get();
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
        return new ApiResponce("Subject is edited",true);
    }

    @Override
    public ApiResponce deleteSubject(Integer id){
        subjectRepository.deleteById(id);
        return new ApiResponce("Subject is deleted",true);
    }
}
