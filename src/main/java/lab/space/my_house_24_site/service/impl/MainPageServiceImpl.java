package lab.space.my_house_24_site.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.my_house_24_site.mapper.MainPageMapper;
import lab.space.my_house_24_site.model.main.MainPageResponse;
import lab.space.my_house_24_site.repository.MainPageRepository;
import lab.space.my_house_24_site.service.MainPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainPageServiceImpl implements MainPageService {
    private final MainPageRepository mainPageRepository;

    @Override
    public MainPageResponse findById() {
        log.info("Try to find main page");
        return MainPageMapper.entityToDto(mainPageRepository.findById(1L).orElseThrow(()->new EntityNotFoundException("Main page not found")));
    }
}
