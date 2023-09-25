package lab.space.my_house_24_site.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.model.contact.ContactResponse;
import lab.space.my_house_24_site.service.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContactController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContactService contactService;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void contactPage() throws Exception {
        mockMvc.perform(get("/contacts"))
                .andExpect(status().isOk())
                .andExpect(view().name("/admin/pages/contact"));
    }

    @Test
    void getContact() throws Exception {
        ContactResponse contactResponse = ContactResponse.builder()
                .address("address")
                .title("title")
                .description("description")
                .url("url")
                .codeMap("codeMap")
                .location("location")
                .fullName("fullname")
                .email("email")
                .build();
        when(contactService.findById()).thenReturn(contactResponse);
        mockMvc.perform(get("/get-contact"))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(contactResponse)));
    }
    @Test
    void getContact_NotFound() throws Exception {
        when(contactService.findById()).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get("/get-contact"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(""));
    }
}