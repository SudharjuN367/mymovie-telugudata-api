package Com.TeluguMovies.Myrules.service;


import Com.TeluguMovies.Myrules.entity.MyMovie;
import Com.TeluguMovies.Myrules.repositiry.MyMovieRepository;
import org.springframework.stereotype.Service;
import  java.util.List;
import  java.util.Optional;

@Service
public class MyMovieService {

    private final MyMovieRepository myrepo;

    public MyMovieService(MyMovieRepository myrepo) {
        this.myrepo = myrepo;
    }
    public MyMovie save (MyMovie mymovie)
    {
        return myrepo.save(mymovie);
    }

    public List<MyMovie> findAll() {

        return myrepo.findAll();
    }

    public Optional<MyMovie> findById(Long id) {
        return myrepo.findById(id);
    }

    public void delete(Long id){
        myrepo.deleteById(id);
    }

    public List<MyMovie>  search (String title, Integer releaseyear){
        return  myrepo.findByTitleContainingIgnoreCaseAndReleaseYear(title,releaseyear);
    }

    public MyMovie update(Long id,MyMovie mymovie){

        MyMovie existing = myrepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        existing.setTitle(mymovie.getTitle());
        existing.setReleaseYear(mymovie.getReleaseYear());
        return myrepo.save(existing);
    }
}
