package managedbean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

import modelo.CarregamentoTeste;
import facade.CarregamentoFacade;
import facade.GenericCrudFacade;

@ManagedBean
@ViewScoped
public class CarregamentoTesteMb extends GenericCrudMb<CarregamentoTeste> {

	@EJB
	private CarregamentoFacade carregamentoFacade;
	
	@Override
	protected GenericCrudFacade<CarregamentoTeste> getServico() {
		return carregamentoFacade;
	}

	@Override
	protected List<CarregamentoTeste> recuperarLista() throws Exception {
		return carregamentoFacade.listar();
	}

}
