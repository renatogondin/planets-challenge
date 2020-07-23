package com.renato.planetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.renato.planetas.model.Planeta;

public interface Planetas extends JpaRepository<Planeta, Long>{
		
}
