package kz.ala.manytomany.controller;

import kz.ala.manytomany.Service.StudentCourseService;
import kz.ala.manytomany.entity.Course;
import kz.ala.manytomany.entity.Student;
import kz.ala.manytomany.repository.CourseRepository;
import kz.ala.manytomany.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/course")
@RequiredArgsConstructor
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student) {
        return studentCourseService.addNewStudentWithCourses(student);
    }

    @GetMapping("/findall")
    public List<Student> findAllStudent() {
        return studentCourseService.findAllStudentsWithCourses();
    }

    @GetMapping("/findById/{studentId}")
    public Optional<Student> findStudent(@PathVariable("studentId") Long studentId) {
        return studentCourseService.findStudent(studentId);
    }

    @GetMapping("/findByName/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name) {
        return studentCourseService.findStudentsContainingName(name);
    }

    @GetMapping("/findByTitle/{title}")
    public List<Course> findCoursesContainingTitle(@PathVariable String title) {
        return studentCourseService.findCoursesContainingTitle(title);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price) {
        return studentCourseService.findCourseCheaperThanPrice(price);
    }

    @GetMapping("/rangeOfId")
    public List<Student> findStudentsInRangeOfId(@RequestParam Long start,
                                                 @RequestParam Long end) {
        return studentCourseService.findRangeById(start, end);
    }

    @GetMapping("/rangeOfModule")
    public List<Course> getCoursesInRangeOfModules(@RequestParam int start,
                                                   @RequestParam int end) {
        return studentCourseService.findRangeByModule(start, end);
    }
}
