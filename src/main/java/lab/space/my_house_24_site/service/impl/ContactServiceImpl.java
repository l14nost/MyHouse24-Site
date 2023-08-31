package lab.space.my_house_24_site.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.mapper.ContactMapper;
import lab.space.my_house_24_site.model.contact.ContactResponse;
import lab.space.my_house_24_site.repository.ContactRepository;
import lab.space.my_house_24_site.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public ContactResponse findById() {
        return ContactMapper.entityToDto(contactRepository.findById(1L).orElseThrow(()-> new EntityNotFoundException("Contact not found")));
    }
}
