package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Carregamento implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;

	private String origem;
	private Double latOrigem;
	private Double lngOrigem;
	private String destino;
	private Double latDestino;
	private Double lngDestino;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Double getLatOrigem() {
		return latOrigem;
	}
	public void setLatOrigem(Double latOrigem) {
		this.latOrigem = latOrigem;
	}
	public Double getLngOrigem() {
		return lngOrigem;
	}
	public void setLngOrigem(Double lngOrigem) {
		this.lngOrigem = lngOrigem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getLatDestino() {
		return latDestino;
	}
	public void setLatDestino(Double latDestino) {
		this.latDestino = latDestino;
	}
	public Double getLngDestino() {
		return lngDestino;
	}
	public void setLngDestino(Double lngDestino) {
		this.lngDestino = lngDestino;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
