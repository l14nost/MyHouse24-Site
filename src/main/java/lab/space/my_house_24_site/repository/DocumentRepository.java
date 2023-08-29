package lab.space.my_house_24_site.repository;

import lab.space.my_house_24_site.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
