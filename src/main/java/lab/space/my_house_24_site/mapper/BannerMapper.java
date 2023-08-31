package lab.space.my_house_24_site.mapper;

import lab.space.my_house_24_site.entity.Banner;
import lab.space.my_house_24_site.model.banner.BannerResponse;

public class BannerMapper {
    public static BannerResponse entityToDto(Banner banner){
        return BannerResponse.builder()
                .image(banner.getImage())
                .name(banner.getName())
                .description(banner.getDescription())
                .build();
    }
}
