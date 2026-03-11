package com.mehmethalman.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity//Veri tabanıma tablo olarak yamsıyacak
@Table(name = "student")// Tablonun ismini verdim
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id // Sen git veri tabanında primaey key olarak belirle demiş oldum
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Veri tabanına her insert ettiğimde otomatik olarak id'yi 1 arttıracaktır
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_of_date", nullable = true)
    private Date birthOfDate;
}
