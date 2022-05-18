package tirocinio.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tirocinio.model.Dipendente;
import tirocinio.model.Recapito;
import tirocinio.persistence.RecapitoRepository;
import tirocinio.service.RecapitoServiceImpl;

@ExtendWith(MockitoExtension.class)
class RecapitoServiceImplTest {

	@InjectMocks
	RecapitoServiceImpl daTestare;
	@Mock
	RecapitoRepository repo;
	
	
	
	
	
	@Test
	final void testCreateRecapito() {
		final Recapito rec =new Recapito(2L, "test@gmail.com", 0, 0, "Roma","00152", "via paola", "33","3334445566", 1L);
		
		when(repo.save(rec)).thenReturn(rec);
		
		Recapito expected = daTestare.createRecapito(rec);
		
		assertThat(expected).isNotNull();
		
		verify(repo).save(any(Recapito.class));
	}

	@Test
	final void testUpdateRecapito() {
		final Recapito rec =new Recapito(2L, "test@gmail.com", 0, 0, "Roma","00152", "via paola", "33","3334445566", 1L);
		
		when(repo.save(rec)).thenReturn(rec);
		
		Recapito expected = daTestare.createRecapito(rec);
		
		assertThat(expected).isNotNull();
		
		verify(repo).save(any(Recapito.class));
		
	}

	@Test
	final void testDeleteRecapito() {
		Long id = 1L;
		daTestare.deleteRecapito(id);
		daTestare.deleteRecapito(id);
		
		verify(repo,times(2)).deleteById(id);
		
	}

	@Test
	final void testGetRecapiti() {
		
		List<Recapito> dati = new ArrayList();
		dati.add(new Recapito(1L, "test@gmail.com", 0, 0, "Roma","00152", "via paola", "33","3334445566", 1L));
		dati.add(new Recapito(2L, "test2@gmail.com", 0, 0, "Roma","00153", "via pigna", "12","3332221177", 1L));
		dati.add(new Recapito(3L, "test3@gmail.com", 0, 0, "Roma","00154", "via carini", "45","3338889900", 1L));
			
		
		when(repo.findAll()).thenReturn(dati);
		
		List<Recapito> expected = daTestare.getRecapiti();
		
		assertEquals(dati,expected);
		
	}

	@Test
	final void testGetRecapito() {
		
		Long id = 1L;
		final Recapito rec =new Recapito(2L, "test@gmail.com", 0, 0, "Roma","00152", "via paola", "33","3334445566", 1L);
		
		when(repo.findById(id)).thenReturn(Optional.of(rec));
		
		final Recapito expected = daTestare.getRecapito(id);
		
		assertThat(expected).isNotNull();
		
		
		
		
	}

}
