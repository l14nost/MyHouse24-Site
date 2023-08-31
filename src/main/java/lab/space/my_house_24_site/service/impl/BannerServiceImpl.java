package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.mapper.BannerMapper;
import lab.space.my_house_24_site.model.banner.BannerResponse;
import lab.space.my_house_24_site.repository.BannerRepository;
import lab.space.my_house_24_site.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;

    @Override
    public Page<BannerResponse> findAllForService(Integer page) {
        return bannerRepository.findAllByServicePage_Id(PageRequest.of(page, 10), 1L).map(BannerMapper::entityToDto);
    }
}
