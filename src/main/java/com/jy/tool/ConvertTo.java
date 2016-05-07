package com.jy.tool;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * @author john
 */
public class ConvertTo {

    public static void main(String[] args) throws Exception {
 /*       String filepath = "src/main/resources/test.docx";
        String path2 = "src/main/resources/test2.doc";
        InputStream inputStream = new FileInputStream(new File
                (filepath));
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
//        System.out.println(ToHtml(""));
        String filepath = "src/main/resources/gongshi.docx";
        String paths[] = filepath.split("/");
        int size = paths.length;
        String path = paths[size-1];
        System.out.println(filepath.split(path)[0]);
    }

    public static String ToHtml(String filepath) throws Exception {
//        String content = new StringBuffer().toString();
        if (filepath.equals("") || filepath == null) {
            filepath = "src/main/resources/gongshi.docx";
        }
        String paths[] = filepath.split("/");
        int size = paths.length;
        String fileRelName = paths[size - 1];
        String path = filepath.split(fileRelName)[0];

        InputStream inputStream = new FileInputStream(new File(filepath));
        if (filepath.matches("(.*).doc$")) {

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

            DocToHtml.convert2Html(filepath, path);
            return extractor.getText();
        } else if (filepath.matches("(.*).docx$")) {

            XWPFDocument document = new XWPFDocument(inputStream);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            DocxToHtml.doGenerateSysOut(filepath, path);
            return extractor.getText();
        }
        return "不支持的格式";
    }

}
