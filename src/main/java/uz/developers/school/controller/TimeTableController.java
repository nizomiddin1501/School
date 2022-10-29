package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.TimeTable;
import uz.developers.school.payload.TimeTableDto;
import uz.developers.school.repository.TimeTableRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class TimeTableController {

    @Autowired
    TimeTableRepository timeTableRepository;


    @GetMapping("/timeTable")
    public List<TimeTable> getTimeTables(){
        List<TimeTable> timeTableList = timeTableRepository.findAll();
        return timeTableList;
    }

    @PostMapping("/timeTable")
    public String addTimeTable(@RequestBody TimeTableDto timeTableDto){
        TimeTable timeTable = new TimeTable();
        timeTable.setName(timeTableDto.getName());
        timeTableRepository.save(timeTable);
        return "TimeTable is added";
    }

    @PutMapping("/timeTable/{id}")
    public String editTimeTable(@PathVariable Integer id,@RequestBody TimeTableDto timeTableDto){
        Optional<TimeTable> optionalTimeTable = timeTableRepository.findById(id);
        if (optionalTimeTable.isPresent()) {
            TimeTable timeTable = optionalTimeTable.get();
            timeTable.setName(timeTableDto.getName());
            timeTableRepository.save(timeTable);
            return "TimeTable is edited";

        }
        return "TimeTable is not found";
    }
    @DeleteMapping("/timeTable/{id}")
    public String deleteTimeTable(@PathVariable Integer id){
        timeTableRepository.deleteById(id);
        return "TimeTable is deleted";
    }


}
