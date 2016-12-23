/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Clothes;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.ClothesModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class ClothesController {
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getall(Model m) {
        ClothesModel model = new ClothesModel();
        m.addAttribute("lst", model.getAll());
        return "Display";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String sendAdd(Model m) {
        m.addAttribute("clothes", new Clothes());
        m.addAttribute("action", "create");
        return "Add";
    }
    
    //
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String create(@ModelAttribute(value = "clothes") Clothes u) {
//        ClothesModel model = new ClothesModel();
//        model.create(u);
//        return "redirect:view.htm";
//    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,@RequestParam CommonsMultipartFile imgUrl, HttpSession session) {
        String path = session.getServletContext().getRealPath("/");
        System.out.println("//===path=="+path);
        String filename = imgUrl.getOriginalFilename();
        try {
            byte barr[] = imgUrl.getBytes();
            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/imgs" + filename));
            System.out.println("//====="+path);
            bout.write(barr);
            System.out.println("//======="+request.getParameter("name"));
            System.out.println("//======="+request.getParameter("id"));
            System.out.println("//======="+request.getParameter("desciption"));
            Clothes c = new Clothes();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setName(request.getParameter("name"));
            c.setImgUrl(filename);
            c.setDesciption(request.getParameter("desciption"));
            ClothesModel model = new ClothesModel();
            model.create(c);
            bout.flush();
            bout.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
         return "Display";
    }
}
