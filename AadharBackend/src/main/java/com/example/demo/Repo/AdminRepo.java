package com.example.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojo.Admin;
public interface AdminRepo extends CrudRepository<Admin, Integer>{
}
