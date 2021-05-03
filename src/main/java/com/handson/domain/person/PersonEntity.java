package com.handson.domain.person;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person", schema = "public")
@Data
public class PersonEntity {

    @Column
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public PersonEntity( int id, String name) {
        this.name = name;
        this.id = id;
    }

    public PersonEntity() {
    }
}
