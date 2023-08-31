package lab.space.my_house_24_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/index")
    public String templatePage(){
        return "/admin/template-simple";
    }

}
