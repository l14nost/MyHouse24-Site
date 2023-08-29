package lab.space.my_house_24_site.repository;

import lab.space.my_house_24_site.entity.MainPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainPageRepository extends JpaRepository<MainPage, Long> {
}
