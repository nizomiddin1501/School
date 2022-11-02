package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.entity.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable,Integer> {
}
