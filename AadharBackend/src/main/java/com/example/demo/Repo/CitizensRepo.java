package com.example.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojo.Citizens;
public interface CitizensRepo extends CrudRepository<Citizens, Integer> {
	// Custom method to check if a citizen with the given email and name exists
	boolean existsByEmailidAndName(String emailid, String name);
}
