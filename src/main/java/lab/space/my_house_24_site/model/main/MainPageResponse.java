package lab.space.my_house_24_site.model.main;

import lab.space.my_house_24_site.model.banner.BannerResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record MainPageResponse(

        String description,
        Boolean links,
        String slide1,
        String slide2,
        String slide3,
        String title,
        List<BannerResponse> bannerList
) {
}
