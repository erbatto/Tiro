package tirocinio.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tirocinio.model.Dipendente;
import tirocinio.persistence.DipendenteRepository;

@Service
public class DipendenteServiceImpl implements DipendenteService {
   
	@Autowired
	DipendenteRepository repo;
	
   
   @Override
   public Dipendente createDipendente(Dipendente dip) {
     return repo.save(dip);
   }
   @Override
   public Dipendente updateDipendente(@RequestBody Dipendente newDipendente, @PathVariable Long personaId) {
	   return repo.findById(personaId)
			      .map(dipendente -> {
			        dipendente.setMatricola(newDipendente.getMatricola());
			        dipendente.setCognome(newDipendente.getCognome());
			        dipendente.setNome(newDipendente.getNome());
			        dipendente.setCodiceFiscale(newDipendente.getCodiceFiscale());
			        dipendente.setData(newDipendente.getData());
			        dipendente.setIdNazioneNascita(newDipendente.getIdNazioneNascita());
			        dipendente.setIdComuneNascita(newDipendente.getIdComuneNascita());
			        dipendente.setIdGenere(newDipendente.getIdGenere());
			        dipendente.setIdStatoCivile(newDipendente.getIdStatoCivile());
			        return repo.save(dipendente);
			      })
			      .orElseGet(() -> {
			        newDipendente.setPersonaId(personaId);
			        return repo.save(newDipendente);
			      });
   }
   @Override
   public void deleteDipendente(Long id) {
	   
		    repo.deleteById(id);

   }
   @Override
   public List<Dipendente> getDipendenti() {
	   	
	   	List<Dipendente> dipendenti = new ArrayList<>();
	   	repo.findAll()
	   	.forEach(dipendenti::add);
	   	return dipendenti;
       
   }
   public Dipendente getDipendente(@PathVariable Long id) {

	    return repo.findById(id)
	      .orElseThrow(() -> new RuntimeException());
	 
   }
   
}