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
@Table(name = "WORDTOHTML")
@DynamicUpdate(value = true)
@DynamicInsert(value = true)
@DiscriminatorValue("WordToHtml")
public class WordToHtml implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int ID;

    @Column(unique = false)
    private String content;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WordToHtml{" +
                "ID=" + ID +
                ", content='" + content + '\'' +
                '}';
    }
}
