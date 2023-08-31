package lab.space.my_house_24_site.mapper;

import lab.space.my_house_24_site.entity.Banner;
import lab.space.my_house_24_site.entity.Seo;
import lab.space.my_house_24_site.model.banner.BannerResponse;
import lab.space.my_house_24_site.model.seo.SeoResponse;

public class SeoMapper {
    public static SeoResponse entityToDto(Seo seo){
        return SeoResponse.builder()
                .description(seo.getDescription())
                .title(seo.getTitle())
                .keyWords(seo.getKeyWords())
                .build();
    }
}
