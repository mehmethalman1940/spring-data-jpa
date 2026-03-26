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
    public List<DtoStudent> findAllStudentNative() {
        return studentServices.findAllStudentNative();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent findStudentByIdNative(@PathVariable(name = "id") Integer id) {
        return studentServices.findStudentByIdNative(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentByIdNative(@PathVariable(name = "id") Integer id) {
        studentServices.deleteStudentByIdNative(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudentIdNative(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
        return studentServices.updateStudentIdNative(id, dtoStudentIU);
    }
}
