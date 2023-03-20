package com.polytech.tindog.Match;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class DogMatch {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String judgingId;

    private String judgedId;
    private Boolean liked;

    public DogMatch() { }

    public DogMatch(String judgingId, String judgedId, Boolean liked) {
        this.id = UUID.randomUUID();
        this.judgingId = judgingId;
        this.judgedId = judgedId;
        this.liked = liked;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getJudgingId() {
        return judgingId;
    }

    public void setJudgingId(String judgingId) {
        this.judgingId = judgingId;
    }

    public String getJudgedId() {
        return judgedId;
    }

    public void setJudgedId(String judgedId) {
        this.judgedId = judgedId;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}
