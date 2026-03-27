package com.mehmethalman.services;

import com.mehmethalman.dto.DtoStudent;
import com.mehmethalman.dto.DtoStudentIU;

import java.util.List;

public interface IStudentServices {

    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> findAllStudentNative();
    public DtoStudent findStudentByIdNative(Integer id);
    public void deleteStudentByIdNative(Integer id);
    public DtoStudent updateStudentIdNative(Integer id, DtoStudentIU dtoStudentIU);
}
