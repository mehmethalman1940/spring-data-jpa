package com.mehmethalman.controller;

import com.mehmethalman.dto.DtoStudent;
import com.mehmethalman.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController {

    public DtoStudent  saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudent();
    public DtoStudent getStuById(Integer id);
    public void deletedStudent(Integer id);
    public DtoStudent updatedStudent(Integer id, DtoStudentIU dtoStudentIU);
}
