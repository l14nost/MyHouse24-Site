package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.entity.Banner;
import lab.space.my_house_24_site.model.banner.BannerResponse;
import lab.space.my_house_24_site.repository.BannerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BannerServiceImplTest {
    @Mock
    private BannerRepository bannerRepository;
    @InjectMocks
    private BannerServiceImpl bannerService;

    @Test
    void findAllForService() {
        Page<Banner> bannerResponses = new PageImpl<>(List.of(
                Banner.builder().build(),
                Banner.builder().build(),
                Banner.builder().build(),
                Banner.builder().build()
        ));
        when(bannerRepository.findAllByServicePage_Id(PageRequest.of(1,10), 1L)).thenReturn(bannerResponses);
        Page<BannerResponse> bannerResponsePage = bannerService.findAllForService(1);
        assertEquals(bannerResponses.getTotalElements(), bannerResponsePage.getTotalElements());
    }
}