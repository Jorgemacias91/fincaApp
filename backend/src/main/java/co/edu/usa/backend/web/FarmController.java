package co.edu.usa.backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.backend.model.Farm;
import co.edu.usa.backend.service.FarmService;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class FarmController {
    
    @Autowired
    private FarmService servicio;
    @GetMapping("/all")
    public List<Farm> getBikes(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Farm> getBike(@PathVariable("id") int bikeId) {
        return servicio.getFarm(bikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm bike) {
        return servicio.save(bike);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm update(@RequestBody Farm bike) {
        return servicio.update(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bikeId) {
        return servicio.delete(bikeId);
    } 
}
