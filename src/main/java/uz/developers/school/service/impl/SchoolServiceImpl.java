package uz.developers.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.school.entity.Address;
import uz.developers.school.entity.School;
import uz.developers.school.payload.ApiResponce;
import uz.developers.school.payload.SchoolDto;
import uz.developers.school.repository.AddressRepository;
import uz.developers.school.repository.SchoolRepository;
import uz.developers.school.service.SchoolService;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchool(Integer id){
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isPresent()) {
            return optionalSchool.get();
        }
        return null;
    }

    @Override
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

    @Override
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

    @Override
    public ApiResponce deleteSchool(Integer id) {
        schoolRepository.deleteById(id);
        return new ApiResponce("School is deleted",true);
    }

}
