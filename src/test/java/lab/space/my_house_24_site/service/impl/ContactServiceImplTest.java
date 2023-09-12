package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.entity.Contact;
import lab.space.my_house_24_site.entity.Seo;
import lab.space.my_house_24_site.model.contact.ContactResponse;
import lab.space.my_house_24_site.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactServiceImplTest {
    @Mock
    private ContactRepository contactRepository;
    @InjectMocks
    private ContactServiceImpl contactService;

    @Test
    void findById() {
        when(contactRepository.findById(1L)).thenReturn(Optional.of(Contact.builder()
                        .address("address")
                        .id(1L)
                        .seo(Seo.builder().description("descr")
                                .title("title")
                                .keyWords("keyWords")
                                .build())
                        .title("title")
                        .description("description")
                        .url("url")
                        .codeMap("codeMap")
                        .location("location")
                        .fullName("fullname")
                        .email("email")
                .build()));
        ContactResponse contactResponse = contactService.findById();
        assertEquals(contactResponse, ContactResponse.builder()
                .address("address")
                .title("title")
                .description("description")
                .url("url")
                .codeMap("codeMap")
                .location("location")
                .fullName("fullname")
                .email("email")
                .build()

        );
    }
}