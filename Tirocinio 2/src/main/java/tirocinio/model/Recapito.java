package tirocinio.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recapito",schema = "public")
public class Recapito implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recapito")
	private Long recapitoId;
	@Column(name = "email")
	private String email;
	@Column(name = "id_nazione")
	private int idNazione;
	@Column(name = "id_comune")
	private int idComune;
	@Column(name = "localita")
	private String  localita;
	@Column(name = "cap")
	private String cap;
	@Column(name = "via")
	private String via;
	@Column(name = "numero_civico")
	private String numeroCivico;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "id_persona")
	private Long personaId;
	public Recapito() {};
	public Recapito(Long id,String email,int id_nazione,int id_comune, String localita,String cap,
			String via,String numero_civico,String telefono,Long personaId) {
		this.recapitoId = id;
		this.email = email;
		this.idNazione = id_nazione;
		this.idComune = id_comune;
		this.localita = localita;
		this.cap = cap;
		this.via = via;
		this.numeroCivico = numero_civico;
		this.telefono = telefono;
		this.personaId= personaId;
		
	}
	
	public Long getRecapitoId() {
		return this.recapitoId;
	}
	public String getEmail() {
		return this.email;
	}
	public int getIdNazione() {
		return this.idNazione;
		
	}
	public int getIdComune() {
		return this.idComune;
	}
	public String getLocalita() {
		return this.localita;
	}
	public String getCap() {
		return this.cap;
	}
	public String getVia() {
		return this.via;
	}
	public String getNumeroCivico() {
		return this.numeroCivico;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public Long getPersonaID() {
		return this.personaId;
	}
	
	
	public void setRecapitoId(Long id) {
		this.recapitoId = id;
		
	}
	public void setEmail(String email) {
		this.email = email;
		
	}
	public void setIdNazione(int id) {
		this.idNazione = id;
	}
	public void setIdComune(int id) {
		this.idComune = id;
	}
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public void setNumeroCivico(String numerocivico) {
		this.numeroCivico = numerocivico;
		
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setPersonaId(Long personaId) {
		
		this.personaId=personaId;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		else if(o== null)
			return false;
		else if(getClass() != o.getClass())
			return false;
		Recapito altro = (Recapito)o;
		return (altro.getRecapitoId() == this.getRecapitoId());
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.recapitoId,this.telefono,this.email);
	}
}
