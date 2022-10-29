package uz.developers.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.school.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {


}
