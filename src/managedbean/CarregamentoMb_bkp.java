package managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Carregamento;
import util.JsfUtil;
import util.Paginador;
import facade.CarregamentoFacade;

@ManagedBean
@ViewScoped
public class CarregamentoMb_bkp implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String LISTAGEM = "listagem";
	private static final String CRIACAO = "criacao";
	private static final String ALTERACAO = "alteracao";
	private static final String EXCLUSAO = "exclusao";
	private Carregamento carregamento;
	private List<Carregamento> lista;
	private String estadoView;
	private String chavePesquisa;
	@EJB
	private CarregamentoFacade facade;
	private Paginador paginador;
	
	@PostConstruct
	private void inicializar() {
		this.estadoView = LISTAGEM;
		this.paginador = new Paginador(10);
	}
	
	public Carregamento getCarregamento() {
		return carregamento;
	}

	public void setCarregamento(Carregamento carregamento) {
		this.carregamento = carregamento;
	}

	public void listar() { 
		try {
			if (chavePesquisa == null || chavePesquisa.trim().isEmpty()) {
				this.lista = facade.listar(paginador.primeiroRegistro(), paginador.getTamanhoPagina());
			} else {
				this.lista = facade.listar(paginador.primeiroRegistro(), paginador.getTamanhoPagina());
				//this.lista = facade.autocomplete(chavePesquisa, paginador);
			}
		} catch (Exception e) {
			JsfUtil.addMsgErro("Erro ao listar: " + e.getMessage());
		}
	}

	public List<Carregamento> getLista() {
		if (lista == null) {
			listar();
		}
		return this.lista;
	}

	public void iniciarCriacao() {
		this.estadoView = CRIACAO;
		this.carregamento = new Carregamento();
	}

	public void iniciarAlteracao(Carregamento carregamento) {
		this.carregamento = carregamento;
		this.estadoView = ALTERACAO;
	}

	public void terminarCriacaoOuAlteracao() {
		try {
			facade.salvar(carregamento);
			JsfUtil.addMsgSucesso("Informações salvas com sucesso.");
			listar();
			this.estadoView = LISTAGEM;
		} catch (Exception e) {
			JsfUtil.addMsgErro("Erro ao salvar: " + e.getMessage());
		}

	}

	public void iniciarExclusao(Carregamento carregamento) {
		this.carregamento = carregamento;
		this.estadoView = EXCLUSAO;
	}

	public void terminarExclusao() {
		try {
			facade.excluir(carregamento);
			JsfUtil.addMsgSucesso("Informações excluídas com sucesso.");
			listar();
			this.estadoView = LISTAGEM;
		} catch (Exception e) {
			JsfUtil.addMsgErro("Erro ao excluir: " + e.getMessage());
		}
	}

	public void cancelar() {
		listar();
		this.estadoView = LISTAGEM;
	}

	public Boolean isListagem() {
		return this.estadoView != null && this.estadoView.equals(LISTAGEM);
	}

	public Boolean isCriacao() {
		return this.estadoView != null && this.estadoView.equals(CRIACAO);
	}

	public Boolean isAlteracao() {
		return this.estadoView != null && this.estadoView.equals(ALTERACAO);
	}

	public Boolean isExclusao() {
		return this.estadoView != null && this.estadoView.equals(EXCLUSAO);
	}

	public String getChavePesquisa() {
		return chavePesquisa;
	}

	public void setChavePesquisa(String chavePesquisa) {
		this.chavePesquisa = chavePesquisa;
	}

	public Boolean temPaginaAnterior() {
		return paginador.getPaginaAtual() > 1;
	}

	public Boolean temProximaPagina() {
		if (lista == null) {
			return false;
		} else {
			return paginador.getTamanhoPagina() <= lista.size();
		}
	}

	public void paginaAnterior() {
		paginador.anterior();
		listar();
	}

	public void proximaPagina() {
		paginador.proxima();
		listar();
	}
}