package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.entity.About;
import lab.space.my_house_24_site.entity.Document;
import lab.space.my_house_24_site.entity.Photo;
import lab.space.my_house_24_site.model.about.AboutResponse;
import lab.space.my_house_24_site.model.about.DocumentResponse;
import lab.space.my_house_24_site.repository.AboutRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AboutServiceImplTest {
    @Mock
    private AboutRepository aboutRepository;

    @InjectMocks
    private AboutServiceImpl aboutService;
    @Test
    void findById() {
        when(aboutRepository.findById(1L)).thenReturn(Optional.of(About.builder()
                        .description("description")
                        .descriptionAdd("descriptionAdd")
                        .title("title")
                        .titleAdd("titleAdd")
                        .documentList(List.of(
                                Document.builder().document("doc").name("docName").build()
                        ))
                        .imageDirector("img")
                        .photoList(List.of(
                                Photo.builder().image("1").type(true).build(),
                                Photo.builder().image("2").type(false).build()
                        ))
                .build()));

        AboutResponse aboutResponse = aboutService.findById();

        assertEquals(AboutResponse.builder()
                        .description("description")
                        .addDescription("descriptionAdd")
                        .title("title")
                        .addTitle("titleAdd")
                        .documentResponses(List.of(
                                DocumentResponse.builder().document("doc").name("docName").build()
                        ))
                        .directorImg("img")
                        .photo(List.of("1"
                        ))
                        .addPhoto(List.of("2")).build()
                ,aboutResponse);

    }
}