package lab.space.my_house_24_site.mapper;

import lab.space.my_house_24_site.entity.Document;
import lab.space.my_house_24_site.model.about.DocumentResponse;

public class DocumentMapper {
    public static DocumentResponse entityToDto(Document document) {
        return DocumentResponse.builder()
                .document(document.getDocument())
                .name(document.getName())
                .build();
    }
}
