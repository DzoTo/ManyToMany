package kz.ala.manytomany.repository;

import kz.ala.manytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);

    Optional<Student> findById(Long id);

//    List<Student> findByLessId(Long id);
//    List<Student> findByBiggerId(Long id);
}
