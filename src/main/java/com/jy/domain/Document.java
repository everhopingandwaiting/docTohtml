package com.jy.domain;

/**
 * @author john
 */

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DOCUMENT")
@DynamicUpdate(value = true)
@DynamicInsert(value = true)
public class Document implements Serializable {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int ID;
    @Column(unique = true)
    private String content;


}
