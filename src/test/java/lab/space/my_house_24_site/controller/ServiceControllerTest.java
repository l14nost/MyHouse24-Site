package lab.space.my_house_24_site.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.model.banner.BannerResponse;
import lab.space.my_house_24_site.model.contact.ContactResponse;
import lab.space.my_house_24_site.service.BannerService;
import lab.space.my_house_24_site.service.ContactService;
import lab.space.my_house_24_site.service.impl.BannerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ServicePageController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BannerService bannerService;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void servicePage() throws Exception {
        mockMvc.perform(get("/service"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/pages/service"));
    }

    @Test
    void getService() throws Exception {
        when(bannerService.findAllForService(0)).thenReturn(new PageImpl<>(
                List.of(
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build(),
                        BannerResponse.builder().build()
                )
        ));
        mockMvc.perform(get("/get-service")
                        .param("page","0"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(
                        new PageImpl<>(
                                List.of(
                                        BannerResponse.builder().build(),
                                        BannerResponse.builder().build(),
                                        BannerResponse.builder().build(),
                                        BannerResponse.builder().build()
                                )
                        )
                )));
    }

}