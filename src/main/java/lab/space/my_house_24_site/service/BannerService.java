package lab.space.my_house_24_site.service;

import lab.space.my_house_24_site.model.banner.BannerResponse;
import org.springframework.data.domain.Page;

public interface BannerService {
    Page<BannerResponse> findAllForService(Integer page);
}
