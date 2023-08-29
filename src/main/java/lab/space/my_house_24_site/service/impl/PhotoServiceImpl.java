package lab.space.my_house_24_site.service.impl;

import lab.space.my_house_24_site.repository.PhotoRepository;
import lab.space.my_house_24_site.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
}
