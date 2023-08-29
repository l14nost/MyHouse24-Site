package lab.space.my_house_24_site.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_page")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Seo seo;

    @OneToMany(mappedBy = "servicePage", cascade = CascadeType.ALL)
    List<Banner> bannerList = new ArrayList<>();

}
