package no.hvl.dat108.festpaamelding;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import no.hvl.dat108.registrering.util.InputValidator;

@Entity
@Table(schema = "dat108")
public class Deltager {
	
	@Id
	@NotBlank(message = "Mobilnummer kan ikke være tomt")
    @Pattern(regexp = "^\\d{8}$", message = "Mobilnummer må være eksakt 8 siffer")
	private String mobil;
	
	@Size(min=2, max=20, message="Fornavn må inneholde minst 2 tegn")
	@NotNull(message = "Navn er obligatorisk")
	@Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-\\s]*", message = "Fornavn kan ikke inneholde tall og første bokstav må være stor")
	private String fornavn;
	
	@Size(min=2, max=20, message="Etternavn må inneholde minst 2 tegn")
	@Pattern(regexp = "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]*", message = "Tall og mellomrom er ikke tillat i etternavn, første bokstav må være stor")
	@NotNull(message = "Etternavn er obligatorisk")
	private String etternavn;
	
	@Pattern(regexp = "^(mann|kvinne)$", message = "Kjønn må være enten 'mann' eller 'kvinne'")
	private String kjonn;
	
	private String hash;
	private String salt;

	public Deltager() {
	}
	
	public Deltager(String mobil, String fornavn, String etternavn, String kjonn, String hash, String salt) {
		super();
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.hash = hash;
		this.salt = salt;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", kjonn=" + kjonn
				+ "]";
	}
	
	

}
