package com.jy.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jy.domain.WordToHtml;
import com.jy.service.WordToHtmlService;
import com.jy.tool.ConvertTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author john
 */
@Controller
public class WordToHtmlController {

    @Autowired
    private WordToHtmlService service;

    /**
     * @return
     */
    @ModelAttribute("documents")
    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public List<WordToHtml> documents() {
        return service.listAll();
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");

        return view;
    }

    @RequestMapping("/save")
    public ModelAndView saveTo() throws Exception {
        ModelAndView view = new ModelAndView();
//        WordToHtml html = new WordToHtml();
//        html.setContent(ConvertTo.ToHtml("test.docx"));
//
//        service.save(html);

        view.setViewName("redirect:/list");
        return view;

    }

    @RequestMapping(value = "/upload",/*headers = "content-type=multipart/form-data",*/ produces = {"application/json;charset=UTF-8"}, method =
            RequestMethod.POST)
    @ResponseBody
    public Object upload(HttpSession httpSession, @RequestParam(value = "file", required = false) MultipartFile file)
            throws Exception {
        String path = httpSession.getServletContext().getRealPath("/files");
        Map<String, String> map =new HashMap<String,String>();
        String msg = "nil", filepath = "";
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("index");
        File tagfile = new File(path, file.getOriginalFilename());
        if (!file.isEmpty()) {
            filepath =  file.getOriginalFilename();
            if (!tagfile.exists()) {
                tagfile.mkdirs();
                file.transferTo(tagfile);
                msg = "success";

                map.put("path", filepath);


            } else {
                msg = "文件已存在";

            }
            WordToHtml html = new WordToHtml();
            html.setContent(ConvertTo.ToHtml(path+"/"+file.getOriginalFilename()));
            html.setPath(filepath);
            html.setHtmlContentPath("files/"+filepath+".html");
            service.save(html);
            System.out.println("save OK");
        } else {
            msg = "上传文件为空!";
        }
        map.put("info", msg);
        System.out.println(filepath);
        return new JSONObject().parseObject(JSON.toJSONString(map));
//        return map;
    }
}
