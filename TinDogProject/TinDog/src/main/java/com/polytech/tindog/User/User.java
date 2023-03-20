package com.polytech.tindog.User;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class User {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String email;
    private String password;

    // Saved manually to the database, it's not controlled by Hibernate
    private String ownerId;
    private String role;

    public User(){}

    public User(UUID id, String email, String password, String ownerId, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.ownerId = ownerId;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", role=" + role +
                '}';
    }
}
