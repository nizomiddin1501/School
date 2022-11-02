package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.Subject;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.SubjectDto;
import uz.developers.school.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getSubjects() {
        List<Subject> subjects = subjectService.getSubjects();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(subjects);
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Integer id) {
        return subjectService.getSubject(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addSubject(@RequestBody SubjectDto subjectDto) {
        ApiResponce apiResponce = subjectService.addSubject(subjectDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editSubject(@PathVariable Integer id, @RequestBody SubjectDto subjectDto) {
        ApiResponce apiResponce = subjectService.editSubject(id,subjectDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Integer id) {
        ApiResponce apiResponce = subjectService.deleteSubject(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
