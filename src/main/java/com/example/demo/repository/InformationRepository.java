package com.example.demo.repository;

import com.example.demo.model.InformationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends CrudRepository<InformationModel,Integer> {
    InformationModel findByUsername(String username);
}
