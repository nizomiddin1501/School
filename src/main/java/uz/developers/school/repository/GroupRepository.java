package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.entity.Group;

public interface GroupRepository extends JpaRepository<Group,Integer> {


}
