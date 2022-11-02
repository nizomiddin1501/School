package uz.developers.school.service;

import uz.developers.school.entity.Group;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.GroupDto;

import java.util.List;

public interface GroupService {
    List<Group> getGroups();

    Group getGroup(Integer id);

    ApiResponce addGroup(GroupDto groupDto);

    ApiResponce editGroup(Integer id, GroupDto groupDto);

    ApiResponce deleteGroup(Integer id);
}
