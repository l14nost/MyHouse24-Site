package lab.space.my_house_24_site.controller;

import jakarta.persistence.EntityNotFoundException;
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
        try {
            return ResponseEntity.ok(mainPageService.findById());
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
