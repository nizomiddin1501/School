package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Mark;
import uz.developers.school.payload.MarkDto;
import uz.developers.school.repository.MarkRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class MarkController {

    @Autowired
    MarkRepository markRepository;


    @GetMapping("/mark")
    public List<Mark> getMarks(){
        List<Mark> markList = markRepository.findAll();
        return markList;
    }

    @PostMapping("/mark")
    public String addMark(@RequestBody MarkDto markDto){
        Mark mark = new Mark();
        mark.setName(markDto.getName());
        markRepository.save(mark);
        return "Mark is added";
    }

    @PutMapping("/mark/{id}")
    public String editMark(@PathVariable Integer id,@RequestBody MarkDto markDto){
        Optional<Mark> optionalMark = markRepository.findById(id);
        if (optionalMark.isPresent()) {
            Mark mark = optionalMark.get();
            mark.setName(markDto.getName());
            markRepository.save(mark);
            return "Mark is edited";
        }
        return "Mark not found";
    }
    @DeleteMapping("/mark/{id}")
    public String deleteMark(@PathVariable Integer id){
        markRepository.deleteById(id);
        return "Mark is deleted";
    }
}
