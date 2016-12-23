/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;
import entity.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MacBook
 */
@Controller
@RequestMapping(value = "/")
public class UploadFileController {

    @RequestMapping(value = "/uploadfile", method = RequestMethod.GET)
    public String getall(Model m) {
        return "FileUploadForm";
    }

    @RequestMapping(value = "/savefile", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();
        try {
            byte barr[] = file.getBytes();
            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/WEB-INF/jsp/upload/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView("FileUploadSuccess", "fileName", path + "" + filename);
    }

}
