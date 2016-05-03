package com.jy.service;

import com.jy.dao.WordToHtmlDao;
import com.jy.domain.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordToHtmlService {
    private WordToHtmlDao wordToHtmlDao;

    public WordToHtmlService(WordToHtmlDao wordToHtmlDao) {
        this.wordToHtmlDao = wordToHtmlDao;
    }

    public List<Document> listAll() {
        return wordToHtmlDao.findAll();
    }


}
