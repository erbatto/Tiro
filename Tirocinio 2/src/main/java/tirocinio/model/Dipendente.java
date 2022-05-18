package tirocinio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity 
@Table(name = "dipendente",schema = "public")
public class Dipendente implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona",insertable=true, updatable=true, unique=true, nullable=false)
	private  Long personaId;
	@Column(name = "matricola")
	private  String matricola;
	@Column(name = "cognome" )
	private  String cognome;
	@Column(name = "nome")
	private  String nome;
	@Column(name = "codice_fiscale")
	private  String codiceFiscale;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascita")
	private Date data;
	@Column(name = "id_nazione_nascita")
	private int idNazioneNascita;
	@Column(name = "id_comune_nascita")
	private int idComuneNascita;
	@Column(name = "id_genere")
	private int idGenere;
	@Column(name = "id_stato_civile")
	private int idStatoCivile;
	@OneToMany(targetEntity = Recapito.class , mappedBy = "personaId")
	private Set<Recapito> recapiti;
	
	
	public Dipendente() {};
	public Dipendente(Long id,String matricola,String cognome,String nome,String codice_fiscale,
			Date data, int id_nazione_nascita,int id_comune_nascita,int id_genere,int id_stato_civile) {
			this.personaId= id;
			this.matricola = matricola;
			this.cognome = cognome;
			this.nome = nome;
			this.codiceFiscale = codice_fiscale;
			this.data = data;
			this.idNazioneNascita = id_nazione_nascita;
			this.idComuneNascita = id_comune_nascita;
			this.idGenere = id_genere;
			this.idStatoCivile = id_stato_civile;
			recapiti = new HashSet<Recapito>();
	}
	public Long getPersonaId() {
		return personaId;
	}
	public String getMatricola() {
		return this.matricola;
	}
	public String getCognome() {
		return this.cognome;
	}
	public String getNome() {
		return this.nome;
	}
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}
	public Date getData() {
		return this.data;
	}
	public int getIdNazioneNascita() {
		return this.idNazioneNascita;
	}
	public int getIdComuneNascita() {
		return idComuneNascita;
	}
	public int getIdGenere() {
		return this.idGenere;
	}
	public int getIdStatoCivile() {
		return this.idStatoCivile;
	}
	public Set<Recapito> getRecapiti() {
		return recapiti;
	}
	
	
	public void setPersonaId(Long id) {
		this.personaId = id;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCodiceFiscale(String codice_fiscale) {
		this.codiceFiscale = codice_fiscale;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setIdNazioneNascita(int id) {
		this.idNazioneNascita = id;
	}
	public void setIdComuneNascita(int id) {
		this.idComuneNascita = id;
	}
	public void setIdStatoCivile(int id ) {
		this.idStatoCivile = id;
	}
	public void setIdGenere(int id ) {
		this.idGenere = id;
	}
	public void setRecapiti(Set<Recapito> recapiti) {
		this.recapiti = recapiti;
	}
	
	

	
	
	
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		else if(o== null)
			return false;
		else if(getClass() != o.getClass())
			return false;
		Dipendente altro = (Dipendente)o;
		return (altro.getPersonaId() == this.getPersonaId());
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.personaId,this.matricola,this.cognome,this.nome);
	}
	
	
	
}	 
