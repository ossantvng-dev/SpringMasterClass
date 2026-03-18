package com.example.controller;

import com.example.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping
    public ResponseEntity<?> retrieveAllCourses() {
        return new ResponseEntity<>(List.of(new Course(1L, "Learn AWS", "in28minutes"),
                new Course(2L, "Learn AWS", "in28minutes"),
                new Course(3L, "Learn Azure", "in28minutes"),
                new Course(4L, "Learn Google Cloud", "in28minutes")), HttpStatus.OK);
    }
}