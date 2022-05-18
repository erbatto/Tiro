package tirocinio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tirocinio.model.Recapito;
import tirocinio.persistence.RecapitoRepository;

@Service
public class RecapitoServiceImpl implements RecapitoService {

	@Autowired
	RecapitoRepository repo;
	
   
   @Override
   public Recapito createRecapito(Recapito rec) {
     return repo.save(rec);
   }
   @Override
   public Recapito updateRecapito(@RequestBody Recapito newRecapito, @PathVariable Long recapitoId) {
	   return repo.findById(recapitoId)
			      .map(recapito -> {
			        recapito.setEmail(newRecapito.getEmail());
			        recapito.setIdNazione(newRecapito.getIdNazione());
			        recapito.setIdComune(newRecapito.getIdComune());
			        recapito.setLocalita(newRecapito.getLocalita());
			        recapito.setCap(newRecapito.getCap());
			        recapito.setVia(newRecapito.getVia());
			        recapito.setNumeroCivico(newRecapito.getNumeroCivico());
			        recapito.setTelefono(newRecapito.getTelefono());
			        return repo.save(recapito);
			      })
			      .orElseGet(() -> {
			        newRecapito.setRecapitoId(recapitoId);
			        return repo.save(newRecapito);
			      });
   }
   @Override
   public void deleteRecapito(Long id) {
	   
		    repo.deleteById(id);

   }
   @Override
   public List<Recapito> getRecapiti() {
	   	
	   	List<Recapito> recapiti = new ArrayList<>();
	   	repo.findAll()
	   	.forEach(recapiti::add);
	   	return recapiti;
       
   }
   public Recapito getRecapito(@PathVariable Long id) {

	    return repo.findById(id)
	      .orElseThrow(() -> new RuntimeException());
	 
   }
	
	
	
	
	
	
}
