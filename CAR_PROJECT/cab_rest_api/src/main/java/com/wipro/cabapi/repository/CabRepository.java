package com.wipro.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.cabapi.entity.Cab;

public interface CabRepository extends JpaRepository<Cab, Integer> {

}
