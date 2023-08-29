package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.ServicePageRepository;
import lab.space.my_house_24_site.service.ServicePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicePageServiceImpl implements ServicePageService {
    private final ServicePageRepository servicePageRepository;
}
