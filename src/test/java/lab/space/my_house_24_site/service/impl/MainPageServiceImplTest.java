package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.entity.*;
import lab.space.my_house_24_site.model.about.AboutResponse;
import lab.space.my_house_24_site.model.about.DocumentResponse;
import lab.space.my_house_24_site.model.banner.BannerResponse;
import lab.space.my_house_24_site.model.main.MainPageResponse;
import lab.space.my_house_24_site.repository.AboutRepository;
import lab.space.my_house_24_site.repository.MainPageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainPageServiceImplTest {
    @Mock
    private MainPageRepository mainPageRepository;

    @InjectMocks
    private MainPageServiceImpl mainPageService;
    @Test
    void findById() {
        when(mainPageRepository.findById(1L)).thenReturn(Optional.of(MainPage.builder()
                .description("description")
                        .slide1("1")
                        .slide2("2")
                        .slide3("3")
                        .links(true)
                        .bannerList(List.of(
                                Banner.builder().build(),
                                Banner.builder().build(),
                                Banner.builder().build(),
                                Banner.builder().build(),
                                Banner.builder().build(),
                                Banner.builder().build()
                        ))
                .title("title")

                .build()));

        MainPageResponse mainPageResponse = mainPageService.findById();

        assertEquals(MainPageResponse.builder()
                        .description("description")
                        .slide1("1")
                        .slide2("2")
                        .slide3("3")
                        .links(true)
                        .bannerList(List.of(
                                BannerResponse.builder().build(),
                                BannerResponse.builder().build(),
                                BannerResponse.builder().build(),
                                BannerResponse.builder().build(),
                                BannerResponse.builder().build(),
                                BannerResponse.builder().build()
                        ))
                        .title("title")
                        .build()
                ,mainPageResponse);

    }
}