package com.olbnar.olddatabaseprocessor.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
   //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profileimageurl")
    private String profileImageUrl;

    @Column(name = "lastlogindate")
    private Date lastLoginDate;

    @Column(name = "lastlogindatedisplay")
    private Date lastLoginDateDisplay;

    @Column(name = "joindate")
    private Date joinDate;

    @Column(name = "roles")
    private String roles; //ROLE_USER, ROLE_ADMIN

    @Column(name = "authorities")
    private String[] authorities;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "isnotlocked")
    private boolean isNotLocked;
}
