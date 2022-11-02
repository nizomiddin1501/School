package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.entity.Group;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.GroupDto;
import uz.developers.school.repository.GroupRepository;
import uz.developers.school.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Group> getGroups(){
         return groupRepository.findAll();
    }

    @Override
    public Group getGroup(Integer id){
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            return optionalGroup.get();
        }
        return null;
    }

    @Override
    public ApiResponce addGroup(GroupDto groupDto){
        Group groups = new Group();
        groups.setName(groupDto.getName());
        groupRepository.save(groups);
        return new ApiResponce("Group is added",true);
    }

    @Override
    public ApiResponce editGroup(Integer id, GroupDto groupDto){
        Optional<Group> optionalGroups = groupRepository.findById(id);
        if (optionalGroups.isEmpty()){
            return new ApiResponce("Group is not found",false);
        }
        Group groups = optionalGroups.get();
        groups.setName(groupDto.getName());
        groupRepository.save(groups);
        return new ApiResponce("Group is edited",true);
    }

    @Override
    public ApiResponce deleteGroup(Integer id){
        groupRepository.deleteById(id);
        return new ApiResponce("Group is deleted",true);
    }
}
