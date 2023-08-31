package lab.space.my_house_24_site.model.seo;

import lombok.Builder;

@Builder
public record SeoResponse(
     String  description,
     String title,
     String keyWords
) {
}
