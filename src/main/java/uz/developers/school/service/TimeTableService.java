package uz.developers.school.service;

import uz.developers.school.entity.TimeTable;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.TimeTableDto;

import java.util.List;

public interface TimeTableService {
    List<TimeTable> getTimeTables();

    TimeTable getTimeTable(Integer id);

    ApiResponce addTimeTable(TimeTableDto timeTableDto);

    ApiResponce editTimeTable(Integer id, TimeTableDto timeTableDto);

    ApiResponce deleteTimeTable(Integer id);

}
