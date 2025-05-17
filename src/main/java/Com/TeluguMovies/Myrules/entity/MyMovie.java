package Com.TeluguMovies.Myrules.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyMovie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    private  String title;

    private  Integer releaseYear;


}
