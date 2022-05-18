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

import tirocinio.model.Recapito;
import tirocinio.service.RecapitoServiceImpl;

@RestController
public class RecapitoController {

	@Autowired
	RecapitoServiceImpl service;

	 


		 
		  @GetMapping("/recapito")
		  List<Recapito> all() {
		    return service.getRecapiti();
		  }
		

		  @PostMapping("/recapito")
		  @ResponseStatus(HttpStatus.CREATED)
		  Recapito newRecapito(@RequestBody Recapito newRecapito) {
		    return service.createRecapito(newRecapito);
		  }

		  
		  
		  @GetMapping("/recapito/{recapitoId}")
		  Recapito uno(@PathVariable Long recapitoId) {
		    
		    return service.getRecapito(recapitoId);
		  }

		  @PutMapping("/recapito/{recapitoId}")
		  Recapito cambiaDipendente(@RequestBody Recapito newRecapito, @PathVariable Long recapitoId) {
		    return service.updateRecapito(newRecapito, recapitoId);
		  }

		  @DeleteMapping("/recapito/{recapitoId}")
		  void deleteRecapito(@PathVariable Long recapitoId) {
			  service.deleteRecapito(recapitoId);
		  }
}