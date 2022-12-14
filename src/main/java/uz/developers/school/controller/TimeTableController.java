package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.TimeTable;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.TimeTableDto;
import uz.developers.school.service.TimeTableService;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimeTableController {

    @Autowired
    TimeTableService timeTableService;

    @GetMapping
    public ResponseEntity<List<TimeTable>> getTimeTables() {
        List<TimeTable> timeTables = timeTableService.getTimeTables();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(timeTables);
    }

    @GetMapping("/{id}")
    public TimeTable getTimeTable(@PathVariable Integer id) {
        return timeTableService.getTimeTable(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addTimeTable(@RequestBody TimeTableDto timeTableDto) {
        ApiResponce apiResponce = timeTableService.addTimeTable(timeTableDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editTimeTable(@PathVariable Integer id, @RequestBody TimeTableDto timeTableDto) {
        ApiResponce apiResponce = timeTableService.editTimeTable(id,timeTableDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTimeTable(@PathVariable Integer id) {
        ApiResponce apiResponce = timeTableService.deleteTimeTable(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


}
