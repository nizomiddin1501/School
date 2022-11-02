package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.entity.Mark;

public interface MarkRepository extends JpaRepository<Mark,Integer> {
}
