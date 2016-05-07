package com.jy.tool;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * Created by john on 16-5-7.
 */
public class DocxToHtml

{
    public static void doGenerateSysOut(String filepath,String path) throws IOException {
        if (filepath.equals("") || filepath == null || path.equals("")) {
            filepath = "src/main/resources/gongshi.docx";
            path = "src/main/resources";
        }
        String fileOutName = path+filepath.split(path)[1] + ".html";

        long startTime = System.currentTimeMillis();

        XWPFDocument document = new XWPFDocument(new FileInputStream(filepath));
        XHTMLOptions options = XHTMLOptions.create().indent(4);
        // Extract image
        File imageFolder = new File(path +"/img" );
        options.setExtractor(new FileImageExtractor(imageFolder));
        // URI resolver
        options.URIResolver(new FileURIResolver(imageFolder));

        File outFile = new File(fileOutName);
        outFile.getParentFile().mkdirs();
        OutputStream out = new FileOutputStream(outFile);
        XHTMLConverter.getInstance().convert(document, out, options);

        System.out.println("Generate " + fileOutName + " with " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void main(String[] args) throws IOException {
        doGenerateSysOut("","");

    }


}