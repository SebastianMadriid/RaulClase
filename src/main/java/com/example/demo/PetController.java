package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.function.Consumer;

@RestController
@RequestMapping("/api")
public class PetController {

    private PetRepository petRepository;

    @Autowired
    public PetController(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @GetMapping("/pet")
    public Iterable<Pet> getAll(){
        return petRepository.findAll();
    }

    @GetMapping("/pet/{id}")
    public Pet get(@PathVariable Long id){
        Pet pet = petRepository.findById(id).orElseThrow();
        return pet;
    }

    @PostMapping("/pet")
    public Pet get(@RequestBody Pet pet){
        return petRepository.save(pet);
    }

    @DeleteMapping("/pet/{id}")
    public HttpStatus delete(@PathVariable Long id){
        petRepository.findById(id).ifPresent(pet -> petRepository.delete(pet));
        return HttpStatus.FORBIDDEN;
    }


    @PutMapping("/pet/{id}")
    public HttpStatus put(@PathVariable Long id, @RequestBody Pet pet){
        petRepository.findById(id).ifPresent(pet1 -> {
            pet.setId(id);
            petRepository.save(pet);
        });
        return HttpStatus.FORBIDDEN;
    }

}
