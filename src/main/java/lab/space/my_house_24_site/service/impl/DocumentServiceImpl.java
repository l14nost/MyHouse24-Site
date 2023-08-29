package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.DocumentRepository;
import lab.space.my_house_24_site.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
}
