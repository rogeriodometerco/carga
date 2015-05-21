package modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Local implements java.io.Serializable {
	@Column(name="DS_NOME")
	private String nome;
	@Column(name="LATITUDE")
	private BigDecimal latitude;
	@Column(name="LONGITUDE")
	private BigDecimal longitude;
	
	public Local() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
	
}
