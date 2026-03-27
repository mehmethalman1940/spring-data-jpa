package com.mehmethalman.repository;

import com.mehmethalman.entites.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> findAllStudentNative();

    @Query(value = "SELECT * FROM student WHERE id= :id", nativeQuery = true)
    Optional<Student> findStudentById(@Param(("id"))Integer id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student WHERE id =:id", nativeQuery = true)
    void deleteStudentByIdNative(@Param(("id"))Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE student SET id = :id WHERE id = :id",nativeQuery = true)
    int updateStudentIdNative();
}

