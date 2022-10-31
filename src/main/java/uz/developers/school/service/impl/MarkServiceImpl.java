package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Mark;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.MarkDto;
import uz.developers.school.repository.MarkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl {

    @Autowired
    MarkRepository markRepository;


    public List<Mark> getMarks(){
        return markRepository.findAll();

    }
    public Mark getMark(Integer id){
        Optional<Mark> optionalMark = markRepository.findById(id);
        if (optionalMark.isPresent()) {
            return optionalMark.get();
        }
        return null;
    }

    public ApiResponce addMark( MarkDto markDto){
        Mark mark = new Mark();
        mark.setName(markDto.getName());
        markRepository.save(mark);
        return new ApiResponce("Mark is added",true);

    }

    public ApiResponce editMark(Integer id, MarkDto markDto){
        Optional<Mark> optionalMark = markRepository.findById(id);
        if (optionalMark.isEmpty()) {
            return new ApiResponce("Mark is not found",false);
        }
        Mark mark = optionalMark.get();
        mark.setName(markDto.getName());
        markRepository.save(mark);
        return new ApiResponce("Mark is edited",true);
    }
    @DeleteMapping("/mark/{id}")
    public ApiResponce deleteMark(@PathVariable Integer id){
        markRepository.deleteById(id);
        return new ApiResponce("Mark is deleted",true);
    }
}
