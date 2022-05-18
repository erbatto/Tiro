package tirocinio.service;





import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tirocinio.model.Dipendente;


public interface DipendenteService {

   public abstract Dipendente createDipendente(Dipendente dip);
   public abstract Dipendente updateDipendente(Dipendente newDipendente,Long personaId);
   public abstract void deleteDipendente(Long id);
   public abstract List<Dipendente> getDipendenti();
   public abstract Dipendente getDipendente(Long id);
   
}