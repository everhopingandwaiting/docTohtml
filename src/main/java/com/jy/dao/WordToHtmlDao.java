package com.jy.dao;

import com.jy.domain.WordToHtml;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *@author john
 *
 */
@Transactional
public class WordToHtmlDao implements Serializable {


    private HibernateTemplate template;

    public WordToHtmlDao(HibernateTemplate template) {
        this.template = template;
    }


    @Transactional(readOnly = true)
    public List<WordToHtml> findAll() {
        return (List<WordToHtml>) template.find("from WordToHtml");

    }

    public void save(WordToHtml wordToHtml) {
        template.save(wordToHtml);
    }

    public void delete(WordToHtml wordToHtml
    ) {
        template.delete(wordToHtml);
    }





}
