package com.mehmethalman.controller;

import com.mehmethalman.dto.DtoStudent;
import com.mehmethalman.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController {

    public DtoStudent  saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> findAllStudentNative();
    public DtoStudent findStudentByIdNative(Integer id);
    public void deleteStudentByIdNative(Integer id);
    public DtoStudent updateStudentIdNative(Integer id, DtoStudentIU dtoStudentIU);
}
