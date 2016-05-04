package com.jy.dao;

import com.jy.domain.Document;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *@author john
 *
 */
@Repository
@Transactional
public class WordToHtmlDao implements Serializable {
    private HibernateTemplate template;

    public WordToHtmlDao(HibernateTemplate template) {
        this.template = template;
    }


    @Transactional(readOnly = true)
    public List<Document> findAll() {
        return (List<Document>) template.find("from Document");

    }

    public void save(Document document) {
        template.save(document);
    }

    public void delete(Document document
    ) {
        template.delete(document);
    }





}
