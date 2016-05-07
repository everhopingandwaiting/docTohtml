package com.jy.domain;

/**
 * @author john
 */

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(unique = false, length = 10240)
    private String content;
    @Column(unique = false)
    private String path;
    @Column(unique = false, length = 10240)
    private String htmlContentPath;

    @Override
    public String toString() {
        return "WordToHtml{" +
                "ID=" + ID +
                ", content='" + content + '\'' +
                ", path='" + path + '\'' +
                ", htmlContentPath='" + htmlContentPath + '\'' +
                '}';
    }

    public String getHtmlContentPath() {
        return htmlContentPath;
    }

    public void setHtmlContentPath(String htmlContentPath) {
        this.htmlContentPath = htmlContentPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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


}
