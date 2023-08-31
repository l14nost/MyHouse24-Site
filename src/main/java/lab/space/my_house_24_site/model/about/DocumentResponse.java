package lab.space.my_house_24_site.model.about;

import lombok.Builder;

@Builder
public record DocumentResponse(
        String name,
        String document
) {
}
