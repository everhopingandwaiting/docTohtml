package com.jy.config;

import com.jy.dao.WordToHtmlDao;
import com.jy.service.WordToHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author john
 */
@Configuration
public class ServiceConfiguration {
//    @Bean
    public WordToHtmlService wordToHtmlService(WordToHtmlDao wordToHtmlDao) {
        return new WordToHtmlService(wordToHtmlDao);
    }
}
