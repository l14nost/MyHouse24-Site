package lab.space.my_house_24_site.controller;

import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.service.ContactService;
import lab.space.my_house_24_site.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/contacts")
    public String contactPage(){
        return "/admin/pages/contact";
    }

    @GetMapping("/get-contact")
    public ResponseEntity getContact(){
        try {
            return ResponseEntity.ok(contactService.findById());
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body("Contact not found");
        }

    }
}

