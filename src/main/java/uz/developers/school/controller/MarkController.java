package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.Mark;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.MarkDto;

import uz.developers.school.service.MarkService;

import java.util.List;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

    @Autowired
    MarkService markService;

    @GetMapping
    public ResponseEntity<List<Mark>> getMarks() {
        List<Mark> marks = markService.getMarks();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(marks);
    }

    @GetMapping("/{id}")
    public Mark getMark(@PathVariable Integer id) {
        return markService.getMark(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addMark(@RequestBody MarkDto markDto) {
        ApiResponce apiResponce = markService.addMark(markDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editMark(@PathVariable Integer id, @RequestBody MarkDto markDto) {
        ApiResponce apiResponce = markService.editMark(id,markDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMark(@PathVariable Integer id) {
        ApiResponce apiResponce = markService.deleteMark(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
