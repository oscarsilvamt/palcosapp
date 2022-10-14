package com.usa.palcosapp.repository;

import com.usa.palcosapp.model.Box;
import com.usa.palcosapp.repository.crudrepository.BoxCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoxRepository {
    @Autowired
    private BoxCrudRepository boxCrudRepository;

    public List<Box> getAll(){
        return (List<Box>) boxCrudRepository.findAll();
    }

    public Optional<Box> getById(Integer id){
        return boxCrudRepository.findById(id);
    }

    public Box save(Box box){
        return boxCrudRepository.save(box);
    }

    public void delete(Box box){
        boxCrudRepository.delete(box);
    }

}
