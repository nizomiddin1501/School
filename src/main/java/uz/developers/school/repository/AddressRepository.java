package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {



}
