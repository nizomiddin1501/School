package uz.developers.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.school.model.Address;
import uz.developers.school.model.School;
import uz.developers.school.payload.SchoolDto;
import uz.developers.school.repository.AddressRepository;
import uz.developers.school.repository.SchoolRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class SchoolController {
    @Autowired
    SchoolRepository schoolRepository;
    AddressRepository addressRepository;


    @GetMapping("/school")
    public List<School> getSchools() {
        List<School> schoolList = schoolRepository.findAll();
        return schoolList;
    }

    @PostMapping("/school")
    public String addSchool(@RequestBody SchoolDto schoolDto) {
        Address address = new Address();
        address.setCity(schoolDto.getCity());
        address.setDistrict(schoolDto.getDistrict());
        address.setStreet(schoolDto.getStreet());
        Address savedAddress = addressRepository.save(address);

        School school = new School();
        school.setName(schoolDto.getName());
        school.setAddress(savedAddress);
        schoolRepository.save(school);
        return "School is added";
    }

    @PutMapping("/school/{id}")
    public String editSchool(@PathVariable Integer id, @RequestBody SchoolDto schoolDto) {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (optionalSchool.isPresent()){
            School school = optionalSchool.get();

            Address address = school.getAddress();

            address.setCity(schoolDto.getCity());
            address.setDistrict(schoolDto.getDistrict());
            address.setStreet(schoolDto.getStreet());
            Address savedAddress = addressRepository.save(address);

            school.setName(schoolDto.getName());
            school.setAddress(savedAddress);
            schoolRepository.save(school);
            return "School is edited";
        }
        return "School not  found";
    }

    @DeleteMapping("/school/{id}")
    public String deleteSchool(@PathVariable Integer id) {
        schoolRepository.deleteById(id);
        return "School is deleted";
    }

}
