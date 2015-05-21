package modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CARREGAMENTO")
public class Carregamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CARREGAMENTO")
	private Integer id;
	@Embedded
	private Local origem;
	@Embedded
	private Local destino;
	@Column(name="DS_PRODUTO")
	private String produto;
	@Column(name="DS_QTDADE")
	private String descricaoQtdade;
	@Column(name="VL_FRETE")
	private BigDecimal vlFrete;

	
	public Carregamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Local getOrigem() {
		return origem;
	}

	public void setOrigem(Local origem) {
		this.origem = origem;
	}

	public Local getDestino() {
		return destino;
	}

	public void setDestino(Local destino) {
		this.destino = destino;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricaoQtdade() {
		return descricaoQtdade;
	}

	public void setDescricaoQtdade(String descricaoQtdade) {
		this.descricaoQtdade = descricaoQtdade;
	}

	public BigDecimal getVlFrete() {
		return vlFrete;
	}

	public void setVlFrete(BigDecimal vlFrete) {
		this.vlFrete = vlFrete;
	}
	
	
}
