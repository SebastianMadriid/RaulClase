package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PetServiceTest {

    private PetService petService;
    
    @Mock
    private PetRepository repository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        petService = new PetServiceImp(repository);
    }
    @Test
    public void getAll(){
        List<Pet> list = Arrays.asList(new Pet(), new Pet());
        when(repository.findAll()).thenReturn(list);
        Iterable<Pet> result = petService.getAll();

        assert result.iterator().hasNext();
        verify(repository).findAll();
    }

    @Test
    public void get(){
        Pet pet = new Pet();
        when(repository.findById(2L)).thenReturn(Optional.of(pet));
        Optional<Pet> resultPet = petService.get(2L);
        Assert.notNull(resultPet.orElseThrow(), "El objeto no puede ser null");
        verify(repository).findById(2L);
    }
}