package lab.space.my_house_24_site.controller;

import lab.space.my_house_24_site.service.AboutService;
import lab.space.my_house_24_site.service.impl.AboutServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;
}
