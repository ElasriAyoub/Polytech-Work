package com.polytech.tindog.Owner;
import com.polytech.tindog.Dog.Dog;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Owner {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String lastname;
    private String profession;
    private String bio;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date birthday;
    private String gender;

    @Lob
    private byte[] picture;

    public Owner() {}

    public Owner(UUID id, String name, String lastname, String profession, String bio, Date birthday, String gender) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.profession = profession;
        this.bio = bio;
        this.birthday = birthday;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
