package managedbean;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import util.JsfUtil;
import facade.GenericCrudFacade;

public abstract class GenericCrudMb<T>  {
	private static final String LISTAGEM = "listagem";
	private static final String CRIACAO = "criacao";
	private static final String ALTERACAO = "alteracao";
	private static final String EXCLUSAO = "exclusao";
	private T entidade;
	private List<T> lista;
	private String estadoView;
	private Integer pagina;
	private Integer tamanhoPagina;

	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}
	
	public List<T> getLista() {
		if (lista == null) {
			listar();
		}
		return lista;
	}

	public void listar() { 
		try {
			this.lista = recuperarLista();
		} catch (Exception e) {
			JsfUtil.addMsgErro("Erro ao listar: " + e.getMessage());
		}
	}

	public void iniciarCriacao() {
		try {
			this.estadoView = CRIACAO;
			this.entidade = getClasseEntidade().newInstance();
		} catch (Exception e) {
			JsfUtil.addMsgErro("Erro ao instanciar entidade: " + e.getMessage());
		}
	}

	public void iniciarAlteracao(T entidade) {
		this.entidade = entidade;
		this.estadoView = ALTERACAO;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getClasseEntidade() {
		return (Class<T>)((ParameterizedType)
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}


	public void salvar() {
		try {
			getServico().salvar(entidade);
			JsfUtil.addMsgSucesso("Informações salvas com sucesso.");
			lista = null;
			this.estadoView = LISTAGEM;
		} catch (Exception e) {
			JsfUtil.addMsgErro("Erro ao salvar: " + e.getMessage());
		}

	}

	public void iniciarExclusao(T entidade) {
		this.entidade = entidade;
		this.estadoView = EXCLUSAO;
	}

	public void excluir() {
		try {
			getServico().excluir(entidade);
			JsfUtil.addMsgSucesso("Registro excluído com sucesso.");
			lista = null;
			this.estadoView = LISTAGEM;
		} catch (Exception e) {
			JsfUtil.addMsgErro("Erro ao excluir: " + e.getMessage());
		}
	}

	public void cancelar() {
		lista = null;
		this.estadoView = LISTAGEM;
	}

	public Boolean exibirListagem() {
		return isListagem();
	}
	
	public Boolean exibirEdicao() {
		return isCriacao() || isAlteracao() || isExclusao();
	}
	
	public Boolean isListagem() {
		System.out.println("isListage() " + this.estadoView == null && this.estadoView.equals(LISTAGEM)); 
		return this.estadoView == null && this.estadoView.equals(LISTAGEM);
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
	
	public void paginaAnterior() {
		if (this.pagina > 1) {
			pagina -= 1;
		}
		listar();
	}
	
	public void proximaPagina() {
		if (lista != null && lista.size() >= tamanhoPagina) {
			pagina += 1;
			listar();
		}
	}
	
	protected abstract GenericCrudFacade<T> getServico();

	protected abstract List<T> recuperarLista() throws Exception;

}