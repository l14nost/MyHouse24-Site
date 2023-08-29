package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.SeoRepository;
import lab.space.my_house_24_site.service.SeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeoServiceImpl implements SeoService {
    private final SeoRepository seoRepository;
}
