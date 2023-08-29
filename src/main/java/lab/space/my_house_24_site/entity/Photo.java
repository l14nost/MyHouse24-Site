package lab.space.my_house_24_site.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "photo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String image;

    @Column(nullable = false)
    private Boolean type;

    @ManyToOne
    private About about;

}
