package kz.ala.manytomany.repository;

import kz.ala.manytomany.entity.Course;
import kz.ala.manytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByFeeLessThan(double fee);

    List<Course> findByTitleContaining(String title);


}
