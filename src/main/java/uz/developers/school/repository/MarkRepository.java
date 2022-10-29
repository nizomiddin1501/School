package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.model.Mark;

public interface MarkRepository extends JpaRepository<Mark,Integer> {
}
