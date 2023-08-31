package lab.space.my_house_24_site.model.banner;

import lombok.Builder;

@Builder
public record BannerResponse(
        String description,
        String image,
        String name
) {
}
