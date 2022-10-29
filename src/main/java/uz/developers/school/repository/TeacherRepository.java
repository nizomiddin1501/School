package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {



}
