package com.gify.giflibs.controller.com.gify.giflibs;

import com.gify.giflibs.data.categoryRepository;
import com.gify.giflibs.data.gifREpository;
import com.gify.giflibs.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {
    //@RequestMapping(value = "/")
   // or

    @Autowired
    private gifREpository gifRepo;
    private categoryRepository catRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {

        List<Gif> all_gifs = gifRepo.getALL_gifs();
        modelMap.put("gifs",all_gifs);
        return "home";

    }


    // URL => Http:// localhost:8080/gift/andriod-explosiion
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap ) {
        Gif gif = gifRepo.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";

    }

}
