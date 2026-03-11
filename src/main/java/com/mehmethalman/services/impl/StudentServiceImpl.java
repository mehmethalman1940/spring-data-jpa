package com.mehmethalman.services.impl;

import com.mehmethalman.dto.DtoStudent;
import com.mehmethalman.dto.DtoStudentIU;
import com.mehmethalman.entites.Student;
import com.mehmethalman.repository.StudentRepository;
import com.mehmethalman.services.IStudentServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentServices {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        DtoStudent response= new DtoStudent();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }


    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoStudentList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoStudentList.add(dtoStudent);
        }
        return dtoStudentList;
    }

    @Override
    public DtoStudent uptateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        DtoStudent dtoStudent  = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()){
            Student dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, dtoStudent );
            return dtoStudent;
        }
        return null;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
             Student dbStudent = optionalStudent.get();
             BeanUtils.copyProperties(dbStudent, dtoStudent);
        }
        return dtoStudent;
    }

    @Override
    public void deletedStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            studentRepository.delete(optionalStudent.get() );
        }


    }
}
