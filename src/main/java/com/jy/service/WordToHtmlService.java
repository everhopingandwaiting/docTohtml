package com.jy.service;

import com.jy.dao.WordToHtmlDao;
import com.jy.domain.WordToHtml;

import java.util.List;

//@Service
public class WordToHtmlService {

    private WordToHtmlDao wordToHtmlDao;

    public WordToHtmlService(WordToHtmlDao wordToHtmlDao) {
        this.wordToHtmlDao = wordToHtmlDao;
    }

    public List<WordToHtml> listAll() {
        return wordToHtmlDao.findAll();
    }


}
