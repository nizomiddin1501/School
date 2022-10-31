package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Group;
import uz.developers.school.payload.GroupDto;
import uz.developers.school.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupServiceImpl {

    @Autowired
    GroupRepository groupRepository;


    @GetMapping
    public List<Group> getGroups(){
        List<Group> groupsList = groupRepository.findAll();
        return groupsList;
    }

    @PostMapping
    public String addGroup(@RequestBody GroupDto groupDto){
        Group groups = new Group();
        groups.setName(groupDto.getName());
        groupRepository.save(groups);
        return "Group is added";
    }

    @PutMapping("/{id}")
    public String editGroup(@PathVariable Integer id,@RequestBody GroupDto groupDto){
        Optional<Group> optionalGroups = groupRepository.findById(id);
        if (optionalGroups.isPresent()){
            Group groups = optionalGroups.get();
            groups.setName(groupDto.getName());
            groupRepository.save(groups);
            return "Group is edoted";
        }
        return "Group not found";
    }
    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable Integer id){
        groupRepository.deleteById(id);
        return "Group is deleted";
    }
}
