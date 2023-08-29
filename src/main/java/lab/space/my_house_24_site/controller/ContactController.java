package lab.space.my_house_24_site.controller;

import lab.space.my_house_24_site.service.ContactService;
import lab.space.my_house_24_site.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
}

