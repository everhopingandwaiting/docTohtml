package com.jy.tool;

import com.jy.domain.WordToHtml;
import com.jy.service.WordToHtmlService;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.Word6Extractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * @author john
 */
public class ConvertTo {

    public static void main(String[] args) throws Exception {
 /*       String path = "src/main/resources/test.docx";
        String path2 = "src/main/resources/test2.doc";
        InputStream inputStream = new FileInputStream(new File
                (path));
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(inputStream);
        } catch (IOException e) {
            HWPFDocument document2 = new HWPFDocument(inputStream);
            e.printStackTrace();
        }
//        HWPFDocument document = new HWPFDocument(inputStream);
        System.out.println(document.getDocument());
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        System.out.println(extractor.getText());
//        WordToHtml html = new WordToHtml();
//        html.setContent(extractor.getText());*/
        System.out.println(ToHtml(""));
    }

    public static String ToHtml(String path) throws Exception {
//        String content = new StringBuffer().toString();
        if (path.equals("") || path == null) {
            path = "src/main/resources/test.doc";
        }
        InputStream inputStream = new FileInputStream(new File(path));
        if (path.matches("(.*).doc$")) {

//            HWPFDocument document = new HWPFDocument(inputStream);
//            return document.getDocumentText();
            WordExtractor extractor = new WordExtractor(inputStream);
            System.out.println(extractor.getTextFromPieces());
            //输出页眉的内容
            System.out.println("页眉：" + extractor.getHeaderText());
            //输出页脚的内容
            System.out.println("页脚：" + extractor.getFooterText());
            //输出当前word文档的元数据信息，包括作者、文档的修改时间等。
            System.out.println(extractor.getMetadataTextExtractor().getText());
            //获取各个段落的文本
            String paraTexts[] = extractor.getParagraphText();
            for (int i=0; i<paraTexts.length; i++) {
                System.out.println("Paragraph " + (i+1) + " : " + paraTexts[i]);
            }
            return extractor.getText();
        } else if (path.matches("(.*).docx$")) {

            XWPFDocument document = new XWPFDocument(inputStream);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);

            return extractor.getText();
        }
        return "不支持的格式";
    }

}
