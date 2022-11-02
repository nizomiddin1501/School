package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
