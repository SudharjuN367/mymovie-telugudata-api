package Com.TeluguMovies.Myrules.repositiry;

import Com.TeluguMovies.Myrules.entity.MyMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMovieRepository  extends JpaRepository<MyMovie ,Long> {
    List<MyMovie> findByTitleContainingIgnoreCaseAndReleaseYear (String title ,Integer releaseYear );



}
