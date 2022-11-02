package uz.developers.school.service;

import uz.developers.school.entity.Mark;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.MarkDto;

import java.util.List;

public interface MarkService {
    List<Mark> getMarks();

    Mark getMark(Integer id);

    ApiResponce addMark(MarkDto markDto);

    ApiResponce editMark(Integer id, MarkDto markDto);

    ApiResponce deleteMark(Integer id);

}
