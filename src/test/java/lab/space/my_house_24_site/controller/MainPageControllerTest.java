package lab.space.my_house_24_site.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.model.about.AboutResponse;
import lab.space.my_house_24_site.model.about.DocumentResponse;
import lab.space.my_house_24_site.model.banner.BannerResponse;
import lab.space.my_house_24_site.model.main.MainPageResponse;
import lab.space.my_house_24_site.service.AboutService;
import lab.space.my_house_24_site.service.MainPageService;
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

@WebMvcTest(MainPageController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class MainPageControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MainPageService mainPageService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void mainPage() throws Exception {
        mockMvc.perform(get("/main"))
                .andExpect(status().isOk())
                .andExpect(view().name("/admin/pages/main"));
    }

    @Test
    void getMainPage() throws Exception {
        MainPageResponse mainPageResponse = MainPageResponse.builder()
                .description("description")
                .slide1("1")
                .slide2("2")
                .slide3("3")
                .links(true)
                .bannerList(List.of(
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build()
                ))
                .title("title")
                .build();
        when(mainPageService.findById()).thenReturn(mainPageResponse);
        mockMvc.perform(get("/get-main-page"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(mainPageResponse)));
    }

    @Test
    void getMainPage_NotFound() throws Exception {
        when(mainPageService.findById()).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get("/get-main-page"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Main page not found"));
    }
}