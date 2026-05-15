package com.app.service;


import com.app.entity.Student;
import com.app.repository.StudentRepository;
import com.app.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    // CREATE
    public Student createStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());
        if (existingStudent.isPresent()) {
            throw new RuntimeException("Student with email " + student.getEmail() + " already exists");
        }
        return studentRepository.save(student);
    }
    
    // READ - Get All
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // READ - Get by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }
    
    // UPDATE
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        
        // Update fields
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setCourse(studentDetails.getCourse());
        
        return studentRepository.save(student);
    }
    
    // DELETE
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}