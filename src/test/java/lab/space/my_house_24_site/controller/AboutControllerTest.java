package lab.space.my_house_24_site.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.model.about.AboutResponse;
import lab.space.my_house_24_site.model.about.DocumentResponse;
import lab.space.my_house_24_site.model.contact.ContactResponse;
import lab.space.my_house_24_site.service.AboutService;
import lab.space.my_house_24_site.service.BannerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AboutController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class AboutControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AboutService aboutService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void aboutPage() throws Exception {
        mockMvc.perform(get("/about"))
                .andExpect(status().isOk())
                .andExpect(view().name("/admin/pages/about"));
    }

    @Test
    void getAbout() throws Exception {
        AboutResponse aboutResponse = AboutResponse.builder()
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
                .addPhoto(List.of("2")).build();
        when(aboutService.findById()).thenReturn(aboutResponse);
        mockMvc.perform(get("/get-about"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(aboutResponse)));
    }

    @Test
    void getAbout_notFound() throws Exception {
        when(aboutService.findById()).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get("/get-about"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("About not found"));
    }
}