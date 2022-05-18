package tirocinio.test.persistence;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tirocinio.model.Dipendente;
import tirocinio.persistence.DipendenteRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(JpaContext.class)
public class DipendenteRepositoryTest {

	
	

	
	@Autowired
	DipendenteRepository dipendenteRepository;
	
	@Test
	public void testCreateDipendente() {
			
		 Dipendente dip = new Dipendente(1L,"matricola", "cognome", "nome", "codicefiscale", null, 1,1, 0, 0);
	      dipendenteRepository.save(dip);
	      Dipendente savedDip = dipendenteRepository.findById(dip.getPersonaId()).get();
	      assertEquals(dip.getPersonaId(), savedDip.getPersonaId());
		
	}
	
	
	@Test
	public void testDeleteDipendente() {
		  
		  Dipendente dip = new Dipendente(1L,"matricola", "cognome", "nome", "codicefiscale", null, 1,1, 0, 0); 
	      dipendenteRepository.save(dip);
	      dipendenteRepository.deleteById(dip.getPersonaId());
	      List<Dipendente> result = new ArrayList<>();
	      dipendenteRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 0);
	   }
		
	
	
	
	@Test
	public void testGetDipendenti() {
		   
		   Dipendente dip = new Dipendente(1L,"matricola", "cognome", "nome", "codicefiscale", null, 1,1, 0, 0);
		      dipendenteRepository.save(dip);
		      List<Dipendente> result = new ArrayList<>();
		      dipendenteRepository.findAll().forEach(e -> result.add(e));
		      assertEquals(result.size(), 1);	     
		   }     
	
	@Test
	public void testGetDipendente() {
		
		Dipendente dip = new Dipendente(1L,"matricola", "cognome", "nome", "codicefiscale", null, 1,1, 0, 0);
		
		Long id = dip.getPersonaId();
		dipendenteRepository.save(dip);
		
		Dipendente savedDip = dipendenteRepository.getById(id);
		
		assertEquals(dip,savedDip);
		
	}

}
