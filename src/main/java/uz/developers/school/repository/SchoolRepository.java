package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.model.School;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
