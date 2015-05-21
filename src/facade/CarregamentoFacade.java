package facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import modelo.CarregamentoTeste;
import dao.CarregamentoDao;

@Stateless
public class CarregamentoFacade extends GenericCrudFacade<CarregamentoTeste> 
	implements Serializable {

	@EJB
	private CarregamentoDao escolaDao;
	
	@Override
	protected CarregamentoDao getDao() {
		return escolaDao;
	}



	@Override
	protected void validar(CarregamentoTeste entidade) throws Exception {
		List<String> erros = new ArrayList<String>();

		if (erros.size() > 0) {
			throw new Exception(erros.toString());
		}
	}

	@Override
	protected void validarExclusao(CarregamentoTeste entidade) throws Exception {
		List<String> erros = new ArrayList<String>();

		if (erros.size() > 0) {
			throw new Exception(erros.toString());
		}
	}

}
