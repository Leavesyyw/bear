package com.example.demo.repository;

import com.example.demo.model.SignModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends CrudRepository<SignModel,Integer> {
      SignModel findByUsername(String username);     //通过用户名寻找
      SignModel findByUsernameAndPassword(String username,String password);   //用户名和密码查找
}
