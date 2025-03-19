package com.UserLogin.UserLogin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_entity")
public class UserEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile", unique = true)
    private String mobile;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}