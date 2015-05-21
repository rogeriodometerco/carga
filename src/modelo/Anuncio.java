package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ANUNCIO")
public class Anuncio implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ANUNCIO")
	private Integer id;
    @ManyToOne
    @JoinColumn(name = "ID_CARREGAMENTO", referencedColumnName = "ID_CARREGAMENTO")
    private Carregamento carregamento;
    
    public Anuncio() {
	}
    
    
	
}
