package com.mehmethalman.services;

import com.mehmethalman.dto.DtoStudent;
import com.mehmethalman.dto.DtoStudentIU;

import java.util.List;

public interface IStudentServices {

    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Integer id);
    public void deletedStudent(Integer id);
    public DtoStudent uptateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
