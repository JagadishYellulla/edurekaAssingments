package com.edu.eduexcellence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class MainRestController {
    @GetMapping("sayhello")
    public ResponseEntity<String> sayHello()
    {
        return ResponseEntity.ok("This is my thrid assignment");
    }

    @Autowired
    StudentRepo studentRepo;
    @PostMapping("students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);

     }

    @GetMapping("getstudents")
     public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);

     }
    @GetMapping("students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
        @PutMapping("students/{id}")
        public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student stud) {
            Optional<Student> student = studentRepo.findById(id);
            if (student.isPresent()) {
                student.get().setStudentName(stud.getStudentName());
                student.get().setStudentEmail(stud.getStudentEmail());
                student.get().setStudentAddress(stud.getStudentAddress());
                return new ResponseEntity<>(studentRepo.save(student.get()), HttpStatus.OK);
            }

            else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

    @DeleteMapping ("students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }



}
