package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.Group;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.GroupDto;
import uz.developers.school.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> getGroups() {
        List<Group> groups = groupService.getGroups();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(groups);
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Integer id) {
        return groupService.getGroup(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponce> addGroup(@RequestBody GroupDto groupDto) {
        ApiResponce apiResponce = groupService.addGroup(groupDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponce> editGroup(@PathVariable Integer id, @RequestBody GroupDto groupDto) {
        ApiResponce apiResponce = groupService.editGroup(id,groupDto);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer id) {
        ApiResponce apiResponce = groupService.deleteGroup(id);
        if (apiResponce.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponce);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
