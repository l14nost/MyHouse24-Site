package lab.space.my_house_24_site.controller;

import lab.space.my_house_24_site.service.AboutService;
import lab.space.my_house_24_site.service.BannerService;
import lab.space.my_house_24_site.service.ServicePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ServicePageController {
    private final BannerService bannerService;

    @GetMapping("/service")
    public ModelAndView servicePage(){
        return new ModelAndView("admin/pages/service");
    }

    @GetMapping("/get-service")
    public ResponseEntity getService(@RequestParam(required = false, defaultValue = "0") Integer page ){
        return ResponseEntity.ok(bannerService.findAllForService(page));
    }
}
