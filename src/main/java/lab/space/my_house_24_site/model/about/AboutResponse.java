package lab.space.my_house_24_site.model.about;

import lombok.Builder;

import java.util.List;
@Builder
public record AboutResponse(
        String description,
        String addDescription,
        String title,
        String addTitle,
        String directorImg,
        List<String> photo,
        List<String> addPhoto,
        List<DocumentResponse> documentResponses

) {
}
