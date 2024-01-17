package com.example.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojo.User;
public interface UserRepo extends CrudRepository<User, Integer>{
}
