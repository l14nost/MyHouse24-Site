package lab.space.my_house_24_site.mapper;

import lab.space.my_house_24_site.entity.MainPage;
import lab.space.my_house_24_site.model.main.MainPageResponse;

public class MainPageMapper {
    public static MainPageResponse entityToDto(MainPage mainPage){
        return MainPageResponse.builder()
                .bannerList(mainPage.getBannerList().stream().map(BannerMapper::entityToDto).toList())
                .description(mainPage.getDescription())
                .links(mainPage.getLinks())
                .slide1(mainPage.getSlide1())
                .slide2(mainPage.getSlide2())
                .slide3(mainPage.getSlide3())
                .title(mainPage.getTitle())
                .build();
    }
}
