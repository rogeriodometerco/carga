package facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import modelo.Carregamento;
import dao.CarregamentoDao;

@Stateless
public class CarregamentoFacade extends GenericCrudFacade<Carregamento> {

	@EJB
	private CarregamentoDao escolaDao;
	
	@Override
	protected CarregamentoDao getDao() {
		return escolaDao;
	}



	@Override
	protected void validar(Carregamento entidade) throws Exception {
		List<String> erros = new ArrayList<String>();

		if (erros.size() > 0) {
			throw new Exception(erros.toString());
		}
	}

	@Override
	protected void validarExclusao(Carregamento entidade) throws Exception {
		List<String> erros = new ArrayList<String>();

		if (erros.size() > 0) {
			throw new Exception(erros.toString());
		}
	}

}
