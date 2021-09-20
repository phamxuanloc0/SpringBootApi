package com.example.springbootapi.entity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
@Entity
@Table(name = "cr_user")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column
    @NotNull
    private String fullName;

    @Column
    @NotNull
    private String password;

    @Column
    private String phone;

    @Column
    private String avatar;

    @Column
    @NotNull
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
