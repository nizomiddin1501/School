package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Address;
import uz.developers.school.model.School;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.SchoolDto;
import uz.developers.school.repository.AddressRepository;
import uz.developers.school.repository.SchoolRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class SchoolServiceImpl {
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    AddressRepository addressRepository;

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public School getSchool(Integer id){
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isPresent()) {
            return optionalSchool.get();
        }
        return null;
    }

    public ApiResponce addSchool(SchoolDto schoolDto) {
        Address address = new Address();
        address.setCity(schoolDto.getCity());
        address.setDistrict(schoolDto.getDistrict());
        address.setStreet(schoolDto.getStreet());
        Address savedAddress = addressRepository.save(address);

        School school = new School();
        school.setName(schoolDto.getName());
        school.setAddress(savedAddress);
        schoolRepository.save(school);
        return new ApiResponce("School is added",true);
    }


    public ApiResponce editSchool(Integer id, SchoolDto schoolDto) {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isEmpty()){

            return new ApiResponce("School is not found",false);
        }
        School school = optionalSchool.get();
        Address address = school.getAddress();

        address.setCity(schoolDto.getCity());
        address.setDistrict(schoolDto.getDistrict());
        address.setStreet(schoolDto.getStreet());
        Address savedAddress = addressRepository.save(address);

        school.setName(schoolDto.getName());
        school.setAddress(savedAddress);
        schoolRepository.save(school);
        return new ApiResponce("School is edited",true);
    }

    public ApiResponce deleteSchool(Integer id) {
        schoolRepository.deleteById(id);
        return new ApiResponce("School is deleted",true);
    }

}
