package com.renato.planetas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.renato.planetas.model.Planeta;

import com.renato.planetas.repository.Planetas;

@RestController
@RequestMapping("/planetas")
public class PlanetasController {
	
	
	
	@Autowired
	private Planetas planetas;
	
	
	@PostMapping
	public Planeta addPlaneta(@RequestBody Planeta planeta) {
		return planetas.save(planeta);
	}
	

	
	@GetMapping
	public List<Planeta> listPlanetas() {
		return planetas.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Planeta> buscarPorId(@PathVariable Long id){
		Optional<Planeta> p = planetas.findById(id);
		if(p.isPresent()) {
			return ResponseEntity.ok(p.get());
		}
		return ResponseEntity.notFound().build();
	}
	

	@RequestMapping(value="/nome", method=RequestMethod.GET)
	public ResponseEntity<Planeta> buscarPorNome(@RequestParam(value="value") String nome) {
		List<Planeta> lista = planetas.findAll();
		for(Planeta p : lista) {
			if(p.getNome().equals(nome)) {
				return ResponseEntity.ok().body(p);
			}
		
	}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removePlaneta(@PathVariable Long id) {
		if (!planetas.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		planetas.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
