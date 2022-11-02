package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.School;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.SchoolDto;
import uz.developers.school.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<School>> getSchools() {
        List<School> schools = schoolService.getSchools();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(schools);
    }

    @GetMapping("/{id}")
    public School getSchool(@PathVariable Integer id) {
        return schoolService.getSchool(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addSchool(@RequestBody SchoolDto schoolDto) {
        ApiResponce apiResponce = schoolService.addSchool(schoolDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editSchool(@PathVariable Integer id, @RequestBody SchoolDto schoolDto) {
        ApiResponce apiResponce = schoolService.editSchool(id,schoolDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable Integer id) {
        ApiResponce apiResponce = schoolService.deleteSchool(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
