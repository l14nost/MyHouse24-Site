package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.MainPageRepository;
import lab.space.my_house_24_site.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {
    private final MainPageRepository mainPageRepository;
}
