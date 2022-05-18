package tirocinio.service;

import java.util.List;

import tirocinio.model.Recapito;

public interface RecapitoService {
	
	  public abstract Recapito createRecapito(Recapito rec);
	   public abstract Recapito updateRecapito(Recapito newRecapito,Long recapitoId);
	   public abstract void deleteRecapito(Long recapitoId);
	   public abstract List<Recapito> getRecapiti();
	   public abstract Recapito getRecapito(Long recapitoId);
	   
}


