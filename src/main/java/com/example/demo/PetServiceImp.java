package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImp implements  PetService{
    private PetRepository repository;

    @Autowired
    public PetServiceImp(PetRepository repository){
        this.repository = repository;
    }

    @Override
    public Iterable<Pet> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pet> get(Long id) {
        return repository.findById(id);
    }
}
