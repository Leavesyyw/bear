package com.example.demo.repository;

import com.example.demo.model.PunchCardModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PunchCardRepository extends CrudRepository<PunchCardModel,Integer> {
      List<PunchCardModel> findByUsername(String username);
}
