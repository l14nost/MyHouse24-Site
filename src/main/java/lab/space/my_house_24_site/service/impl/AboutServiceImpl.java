package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.AboutRepository;
import lab.space.my_house_24_site.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;
}
