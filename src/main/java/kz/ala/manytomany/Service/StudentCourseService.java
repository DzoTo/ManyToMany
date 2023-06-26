package kz.ala.manytomany.Service;

import kz.ala.manytomany.entity.Course;
import kz.ala.manytomany.entity.Student;
import kz.ala.manytomany.repository.CourseRepository;
import kz.ala.manytomany.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentCourseService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public List<Student> findAllStudentsWithCourses() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudent(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student addNewStudentWithCourses(Student student) {
//        Optional<Student> studentOptional = studentRepository.findById(student.getId());
//        if(studentOptional.isPresent()){
//            throw new IllegalStateException("Save is not available");
//        }
        return studentRepository.save(student);
    }

    public List<Student> findStudentsContainingName(String name) {
        return studentRepository.findByNameContaining(name);
    }

    public List<Course> findCoursesContainingTitle(String title) {
        return courseRepository.findByTitleContaining(title);
    }
    public List<Course> findCourseCheaperThanPrice(double price) {
        return courseRepository.findByFeeLessThan(price);
    }

    public List<Student> findRangeById(Long start, Long end){
//        List<Student> list1 = studentRepository.findByLessId(id+range);
//        List<Student> list2 = studentRepository.findByBiggerId(id-range);
        List<Student> listNeed = new ArrayList<>();

        List<Student> list1 = studentRepository.findAll();
        for(Student student: list1){
           if(student.getId()>=start && student.getId()<=end){
               listNeed.add(student);
           }
        }
        return listNeed;
    }

    public List<Course> findRangeByModule(int start, int end){
        List<Course> list1 = courseRepository.findAll();
        List<Course> listNeed = new ArrayList<>();
        for(Course course: list1){
            if(course.getModules()>=start && course.getModules()<=end){
                listNeed.add(course);
            }
        }
        return listNeed;
    }
}
