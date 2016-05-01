package com.jy.dao;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.Word6Extractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *  @author john
 */
public class ConvertTo {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream(new File
                ("src/main/resources/test.docx"));
        XWPFDocument document = new XWPFDocument(inputStream);
//        HWPFDocument document = new HWPFDocument(inputStream);
        System.out.println(document.getDocument());
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        System.out.println(extractor.getText());

    }

    public static String ToHtml(String path) throws Exception{
//        String content = new StringBuffer().toString();
        if (path.equals("") || path == null) {
            path = "src/main/resources/test.docx";
        }
        InputStream inputStream = new FileInputStream(new File(path));
        XWPFDocument document = new XWPFDocument(inputStream);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        return extractor.getText();
    }

}
