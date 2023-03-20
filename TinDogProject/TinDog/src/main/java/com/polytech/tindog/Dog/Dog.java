package com.polytech.tindog.Dog;
import com.polytech.tindog.Message.Message;
import com.polytech.tindog.Owner.Owner;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Dog {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String dogname;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date birthday;
    private String bio;

    private String gender;
    @Lob
    private byte[] picture;

    private String ownerId;

    public Dog() {}

    public Dog(String dogname, Date birthday, String bio, String gender, String ownerId) {
        this.id = UUID.randomUUID();
        this.dogname = dogname;
        this.birthday = birthday;
        this.bio = bio;
        this.gender = gender;
        this.ownerId = ownerId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
