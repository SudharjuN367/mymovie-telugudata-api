package Com.TeluguMovies.Myrules.controller;

import Com.TeluguMovies.Myrules.entity.MyMovie;
import Com.TeluguMovies.Myrules.service.MyMovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Tag(name ="MyMovie API", description ="CRUD operations and search for Movies")
public class MyMovieController {

    private final MyMovieService service;


    public MyMovieController(MyMovieService service) {
        this.service = service;
    }
@PostMapping
 public ResponseEntity<MyMovie> create(@RequestBody MyMovie movie){

        return ResponseEntity.ok(service.save(movie));
}

@GetMapping
    public ResponseEntity<List<MyMovie>> getALL()
{

    return ResponseEntity.ok(service.findAll());

}

@GetMapping("/{id}")
    public ResponseEntity<MyMovie> getBtId(@PathVariable Long id)
{
    return  service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

}

@PutMapping("/{id}")
public ResponseEntity<MyMovie> update(@PathVariable Long id, @RequestBody MyMovie mymovie)
{
    return ResponseEntity.ok(service.update(id,mymovie));
}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
{

    service.delete(id);
    return ResponseEntity.noContent().build();
}

@GetMapping("/search")
    public ResponseEntity<List<MyMovie>> search(@RequestParam String title, @RequestParam Integer releaseYear){

        return ResponseEntity.ok(service.search(title,releaseYear));
}




}