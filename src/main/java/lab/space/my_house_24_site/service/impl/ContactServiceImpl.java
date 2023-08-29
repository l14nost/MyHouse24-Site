package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.ContactRepository;
import lab.space.my_house_24_site.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
}
