package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Subject;
import uz.developers.school.payload.SubjectDto;
import uz.developers.school.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;
//todo Service ga aylantirish shu classdan qolgan

@RestController
public class SubjectServiceImpl {

    @Autowired
    SubjectRepository subjectRepository;


    public List<Subject> getSubjects(){
       return subjectRepository.findAll();

    }

    public String addSubject(SubjectDto subjectDto){
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
        return "Subject is added";
    }

    public String editSubject(Integer id, SubjectDto subjectDto){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subject.setName(subjectDto.getName());
            subjectRepository.save(subject);
            return "Subject is edited";
        }
        return "Subject not found";
    }
    public String deleteSubject(Integer id){
        subjectRepository.deleteById(id);
        return "Subject is deleted";
    }
}
