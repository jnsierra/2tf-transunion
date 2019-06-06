package co.transunion.service;

import java.rmi.RemoteException;

import org.json.JSONException;

import com.asobancaria.cifin.infocomercial.dto.ParametrosConsultaDTO;

import co.transunion.dto.SecurityDto;

public interface IComercialInformationService {

	/**
	 * 
	 * @param parameters
	 * @param stub
	 * @return json response
	 */
	String	getComercialInformation(ParametrosConsultaDTO parameters, SecurityDto security) throws RemoteException,JSONException;
}
