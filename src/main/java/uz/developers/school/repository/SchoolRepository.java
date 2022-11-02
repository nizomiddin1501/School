package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.entity.School;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
