package lab.space.my_house_24_site.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banner")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(length = 150, nullable = false)
    private String image;

    @ManyToOne
    private ServicePage servicePage;

    @ManyToOne
    private MainPage mainPage;

}
