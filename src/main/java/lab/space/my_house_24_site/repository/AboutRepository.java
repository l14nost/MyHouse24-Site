package lab.space.my_house_24_site.repository;

import lab.space.my_house_24_site.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
}
