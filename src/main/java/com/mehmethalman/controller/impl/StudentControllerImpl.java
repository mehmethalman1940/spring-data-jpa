package com.mehmethalman.controller.impl;

import com.mehmethalman.controller.IStudentController;
import com.mehmethalman.dto.DtoStudent;
import com.mehmethalman.dto.DtoStudentIU;
import com.mehmethalman.services.IStudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentServices studentServices;

    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
        return studentServices.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudent() {
        return studentServices.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStuById(@PathVariable(name = "id") Integer id) {
        return studentServices.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deletedStudent(@PathVariable(name = "id") Integer id) {
        studentServices.deletedStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updatedStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
        return studentServices.uptateStudent(id, dtoStudentIU);
    }
}
