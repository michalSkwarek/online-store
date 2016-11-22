package com.skwarek.onlineStore.data.entity;

import javax.persistence.*;

/**
 * Created by Michal on 22/11/2016.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
