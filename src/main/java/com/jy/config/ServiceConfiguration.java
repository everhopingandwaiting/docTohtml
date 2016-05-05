package com.jy.config;

import com.jy.dao.WordToHtmlDao;
import com.jy.service.WordToHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author john
 */
@Configuration
//@Service
public class ServiceConfiguration {
    @Bean
    public WordToHtmlService wordToHtmlService(WordToHtmlDao wordToHtmlDao) {
        return new WordToHtmlService(wordToHtmlDao);
    }
}
