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
import tirocinio.persistence.DipendenteRepository;
import tirocinio.service.DipendenteServiceImpl;

@ExtendWith(MockitoExtension.class)
class DipendenteServiceImplTest {

	@InjectMocks
	DipendenteServiceImpl daTestare;
	@Mock
	DipendenteRepository repo;
	
	
	
	
	
	@Test
	final void testCreateDipendente() {
		final Dipendente dip = new Dipendente(1L,"matricola", "cognome", "nome", "codicefiscale", null, 1,1, 0, 0);
		
		when(repo.save(dip)).thenReturn(dip);
		
		Dipendente expected = daTestare.createDipendente(dip);
		
		assertThat(expected).isNotNull();
		
		verify(repo).save(any(Dipendente.class));
	}

	@Test
	final void testUpdateDipendente() {
		final Dipendente dip = new Dipendente(1L,"matricola", "cognome", "nome", "codicefiscale", null, 1,1, 0, 0);
		
		when(repo.save(dip)).thenReturn(dip);
		
		Dipendente expected = daTestare.createDipendente(dip);
		
		assertThat(expected).isNotNull();
		
		verify(repo).save(any(Dipendente.class));
		
	}

	@Test
	final void testDeleteDipendente() {
		Long id = 1L;
		daTestare.deleteDipendente(id);
		daTestare.deleteDipendente(id);
		
		verify(repo,times(2)).deleteById(id);
		
	}

	@Test
	final void testGetDipendenti() {
		
		List<Dipendente> dati = new ArrayList();
		dati.add(new Dipendente(1L,"matricola", "cognome", "nome", "codicefiscale", null, 1,1, 0, 0));
		dati.add(new Dipendente(2L,"matricola2", "cognome2", "nome2", "codicefiscale2", null, 1,1,0, 0));
		dati.add(new Dipendente(3L,"matricola3", "cognome3", "nome3", "codicefiscale3", null, 1,1, 0, 0));
		
		
		when(repo.findAll()).thenReturn(dati);
		
		List<Dipendente> expected = daTestare.getDipendenti();
		
		assertEquals(dati,expected);
		
	}

	@Test
	final void testGetDipendente() {
		
		Long id = 1L;
		final Dipendente  dip = new Dipendente(1L, "matricola", "cognome", null, null, null, 0, 0, 0, 0);
		
		when(repo.findById(id)).thenReturn(Optional.of(dip));
		
		final Dipendente expected = daTestare.getDipendente(id);
		
		assertThat(expected).isNotNull();
		
		
		
		
	}

}
