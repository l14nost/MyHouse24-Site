package lab.space.my_house_24_site.controller;

import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.service.ContactService;
import lab.space.my_house_24_site.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/contacts")
    public ModelAndView contactPage(){
        return new ModelAndView("admin/pages/contact");
    }

    @GetMapping("/get-contact")
    public ResponseEntity getContact(){
        try {
            return ResponseEntity.ok(contactService.findById());
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

