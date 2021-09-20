package com.example.springbootapi.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name")
    @NotBlank(message = "Please add first name!")
    @Length(max = 10, min= 1, message = "less than ten and greater than one")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Please input a email!")
    private String mail;
}
