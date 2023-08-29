package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.BannerRepository;
import lab.space.my_house_24_site.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;
}
