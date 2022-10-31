package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Subject;
import uz.developers.school.payload.SubjectDto;
import uz.developers.school.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectServiceImpl {

    @Autowired
    SubjectRepository subjectRepository;


    @GetMapping("/subject")
    public List<Subject> getSubjects(){
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }

    @PostMapping("/subject")
    public String addSubject(@RequestBody SubjectDto subjectDto){
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
        return "Subject is added";
    }

    @PutMapping("/subject/{id}")
    public String editSubject(@PathVariable Integer id,@RequestBody SubjectDto subjectDto){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subject.setName(subjectDto.getName());
            subjectRepository.save(subject);
            return "Subject is edited";
        }
        return "Subject not found";
    }
    @DeleteMapping("/subject/{id}")
    public String deleteSubject(@PathVariable Integer id){
        subjectRepository.deleteById(id);
        return "Subject is deleted";
    }
}
