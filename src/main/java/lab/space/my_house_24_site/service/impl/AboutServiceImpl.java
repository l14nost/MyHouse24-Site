package lab.space.my_house_24_site.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.mapper.AboutMapper;
import lab.space.my_house_24_site.model.about.AboutResponse;
import lab.space.my_house_24_site.repository.AboutRepository;
import lab.space.my_house_24_site.service.AboutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;

    @Override
    public AboutResponse findById() {
        log.info("Try to find about page");
        return AboutMapper.entityToDto(aboutRepository.findById(1L).orElseThrow(()->new EntityNotFoundException("About not found")));
    }
}
