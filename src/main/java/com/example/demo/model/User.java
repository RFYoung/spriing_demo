package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Data
@Entity
@Table(name = "t_sys_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="phone_num")
    private Integer phone_num;

    @Column(name="ext_id",nullable = false)
    private Integer externalId;

    @Column(name="roles")
    private String roles;



}

