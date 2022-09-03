package com.example.crud.crud;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarroController {

    CarroRepository repository;

    @GetMapping("/carros")
    public List<Carro> getAllCarros() {
        return repository.findAll();
    }

    @GetMapping("/carros/{id}")
    public Carro getCarroById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/carros")
    public Carro storeCarro(@RequestBody Carro carro) {
        return repository.save(carro);
    }

    @DeleteMapping("/carros/{id}")
    public void deleteCarroById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/carros/{id}")
    public Carro updateCarro(@PathVariable Long id, @RequestBody Carro carro) {
        carro.setId(id);
        return repository.save(carro);
    }
}
