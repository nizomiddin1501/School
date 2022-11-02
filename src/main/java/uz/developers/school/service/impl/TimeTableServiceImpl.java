package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.school.entity.TimeTable;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.TimeTableDto;
import uz.developers.school.repository.TimeTableRepository;
import uz.developers.school.service.TimeTableService;


import java.util.List;
import java.util.Optional;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    TimeTableRepository timeTableRepository;

    @Override
    public List<TimeTable> getTimeTables(){
        return timeTableRepository.findAll();
    }

    @Override
    public TimeTable getTimeTable(Integer id){
        Optional<TimeTable> optionalTimeTable = timeTableRepository.findById(id);
        if (optionalTimeTable.isPresent()) {
            return optionalTimeTable.get();
        }
        return null;
    }

    @Override
    public ApiResponce addTimeTable(TimeTableDto timeTableDto){
        TimeTable timeTable = new TimeTable();
        timeTable.setName(timeTableDto.getName());
        timeTableRepository.save(timeTable);
        return new ApiResponce("TimeTable is added",true);
    }
    @Override
    public ApiResponce editTimeTable(Integer id, TimeTableDto timeTableDto){
        Optional<TimeTable> optionalTimeTable = timeTableRepository.findById(id);
        if (optionalTimeTable.isEmpty()) {
            return new ApiResponce("TimeTable is not found",false);
        }
        TimeTable timeTable = optionalTimeTable.get();
        timeTable.setName(timeTableDto.getName());
        timeTableRepository.save(timeTable);
        return new ApiResponce("TimeTable is edited",true);
    }

    @Override
    public ApiResponce deleteTimeTable(Integer id){
        timeTableRepository.deleteById(id);
        return new ApiResponce("TimeTable is deleted",true);
    }
}
