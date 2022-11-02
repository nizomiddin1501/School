package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.Mark;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.MarkDto;
import uz.developers.school.repository.MarkRepository;
import uz.developers.school.service.MarkService;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    MarkRepository markRepository;


    @Override
    public List<Mark> getMarks(){
        return markRepository.findAll();

    }

    @Override
    public Mark getMark(Integer id){
        Optional<Mark> optionalMark = markRepository.findById(id);
        if (optionalMark.isPresent()) {
            return optionalMark.get();
        }
        return null;
    }

    @Override
    public ApiResponce addMark( MarkDto markDto){
        Mark mark = new Mark();
        mark.setName(markDto.getName());
        markRepository.save(mark);
        return new ApiResponce("Mark is added",true);

    }

    @Override
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

    @Override
    public ApiResponce deleteMark(Integer id){
        markRepository.deleteById(id);
        return new ApiResponce("Mark is deleted",true);
    }
}
