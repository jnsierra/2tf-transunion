package co.transunion.service;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.cifin.confrontaultra.dto.ultra.CuestionarioULTRADTO;
import co.cifin.confrontaultra.dto.ultra.ParametrosSeguridadULTRADTO;
import co.cifin.confrontaultra.dto.ultra.ParametrosULTRADTO;
import corp.universo.ttuweb3.cifin.confrontav2plusws.services.ConfrontaUltraWS.ConfrontaUltraWSSoapBindingStub;

@Service
public class CuestionarioService implements ICuestionarioService {
	
	@Autowired
	ConfrontaUltraWSSoapBindingStub confrontaUltraWSSoapBindingStub;

	@Override
	public CuestionarioULTRADTO getCuestionario(ParametrosULTRADTO parametros, ParametrosSeguridadULTRADTO security) throws RemoteException {
		return confrontaUltraWSSoapBindingStub.obtenerCuestionario(security, parametros);
	}

}
