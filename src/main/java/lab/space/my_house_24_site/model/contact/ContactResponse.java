package lab.space.my_house_24_site.model.contact;

import lombok.Builder;

@Builder
public record ContactResponse(
        String address,
        String codeMap,
        String description,
        String fullName,
        String title,
        String url,
        String email,
        String number,
        String location
) {
}
