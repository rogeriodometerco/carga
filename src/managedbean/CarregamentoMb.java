package managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Carregamento;
import facade.CarregamentoFacade;
import facade.GenericCrudFacade;

@ManagedBean
@ViewScoped
public class CarregamentoMb extends GenericCrudMb<Carregamento>
	implements Serializable {

	@EJB
	private CarregamentoFacade carregamentoFacade;
	
	@Override
	protected GenericCrudFacade<Carregamento> getServico() {
		return carregamentoFacade;
	}

	@Override
	protected List<Carregamento> recuperarLista() throws Exception {
		return carregamentoFacade.listar(getPagina() * getTamanhoPagina() - getTamanhoPagina(), getTamanhoPagina());
	}
	

}
