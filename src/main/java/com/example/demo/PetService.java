package com.example.demo;

import java.util.Optional;

public interface PetService {
    Iterable<Pet> getAll();

    Optional<Pet> get(Long i);
}
