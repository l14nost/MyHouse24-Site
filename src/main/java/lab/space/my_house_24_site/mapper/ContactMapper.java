package lab.space.my_house_24_site.mapper;

import lab.space.my_house_24_site.entity.Contact;
import lab.space.my_house_24_site.model.contact.ContactResponse;

public class ContactMapper {
    public static ContactResponse entityToDto(Contact contact) {
        return ContactResponse.builder()
                .address(contact.getAddress())
                .title(contact.getTitle())
                .url(contact.getUrl())
                .location(contact.getLocation())
                .description(contact.getDescription())
                .email(contact.getEmail())
                .fullName(contact.getFullName())
                .codeMap(contact.getCodeMap())
                .number(contact.getNumber())
                .build();
    }
}
