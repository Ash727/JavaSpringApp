package com.gify.giflibs.controller.com.gify.giflibs;

import com.gify.giflibs.data.gifREpository;
import com.gify.giflibs.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class GifController {
    //@RequestMapping(value = "/")
   // or

    @Autowired
    private gifREpository gifRepo;

    @RequestMapping("/")
    public String listGifs() {
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
