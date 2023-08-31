package lab.space.my_house_24_site.controller;

import lab.space.my_house_24_site.service.AboutService;
import lab.space.my_house_24_site.service.impl.AboutServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;

    @GetMapping("/about")
    public String aboutPage(){
        return "/admin/pages/about";
    }

    @GetMapping("/get-about")
    public ResponseEntity getAbout(){
        return ResponseEntity.ok(aboutService.findById());
    }
}
