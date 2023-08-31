package lab.space.my_house_24_site.controller;

import lab.space.my_house_24_site.service.AboutService;
import lab.space.my_house_24_site.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final MainPageService mainPageService;
    @GetMapping("/main")
    public String mainPage(){
        return "/admin/pages/main";
    }

    @GetMapping("/get-main-page")
    public ResponseEntity getMainPage(){
        return ResponseEntity.ok(mainPageService.findById());
    }
}
