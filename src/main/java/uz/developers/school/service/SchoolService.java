package uz.developers.school.service;

import uz.developers.school.entity.School;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.SchoolDto;

import java.util.List;

public interface SchoolService {
    List<School> getSchools();

    School getSchool(Integer id);

    ApiResponce addSchool(SchoolDto schoolDto);

    ApiResponce editSchool(Integer id, SchoolDto schoolDto);

    ApiResponce deleteSchool(Integer id);

}
