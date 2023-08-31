package lab.space.my_house_24_site.mapper;

import lab.space.my_house_24_site.entity.About;
import lab.space.my_house_24_site.entity.Photo;
import lab.space.my_house_24_site.model.about.AboutResponse;

import java.util.ArrayList;
import java.util.List;

public class AboutMapper {
    public static AboutResponse entityToDto(About about){

        List<String> photo = new ArrayList<>();
        List<String> addPhoto = new ArrayList<>();
        for (Photo photo1: about.getPhotoList()){
            if (photo1.getType()){
                photo.add(photo1.getImage());
            }
            else {
                addPhoto.add(photo1.getImage());
            }
        }
        return AboutResponse.builder()
                .photo(photo)
                .addPhoto(addPhoto)
                .title(about.getTitle())
                .addTitle(about.getTitleAdd())
                .description(about.getDescription())
                .addDescription(about.getDescriptionAdd())
                .documentResponses(about.getDocumentList().stream().map(DocumentMapper::entityToDto).toList())
                .directorImg(about.getImageDirector())
                .build();
    }
}
