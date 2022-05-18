package tirocinio.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tirocinio.model.Dipendente;
import tirocinio.service.DipendenteServiceImpl;

@RestController
public class DipendenteController {

	@Autowired
	DipendenteServiceImpl service;

	 


		 
		  @GetMapping("/dipendente")
		  List<Dipendente> all() {
		   return  service.getDipendenti();
		  }
		

		  @PostMapping("/dipendente")
		  @ResponseStatus(HttpStatus.CREATED)
		  Dipendente newDipendente(@RequestBody Dipendente newDipendente) {
		    return service.createDipendente(newDipendente);
		  }

		  
		  
		  @GetMapping("/dipendente/{personaId}")
		  Dipendente uno(@PathVariable Long personaId) {

			  return service.getDipendente(personaId);
		   
		  }

		  @PutMapping("/dipendente/{personaId}")
		  Dipendente cambiaDipendente(@RequestBody Dipendente newDipendente, @PathVariable Long personaId) {
		    
			  return service.updateDipendente(newDipendente, personaId);
		  }

		  @DeleteMapping("/dipendente/{personaId}")
		  void deleteDipendente(@PathVariable Long personaId) {
		    service.deleteDipendente(personaId);
		  }
}
	

