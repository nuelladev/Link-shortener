package com.example.LinkShortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class LinkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @JsonIgnore
    private Long id;

    @NaturalId
    @Column(unique = true, nullable = false)
    private String alias;

    @Column(nullable = false)
    private String url;

    public LinkModel(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }

    @Override
    public String toString() {
        return "LinkModel{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

