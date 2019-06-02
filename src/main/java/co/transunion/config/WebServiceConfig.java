package co.transunion.config;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import corp.universo.ttuweb3.cifin.confrontav2plusws.services.ConfrontaUltraWS.ConfrontaUltraWSSoapBindingStub;
import corp.universo.ttuweb3.cifin.confrontav2plusws.services.ConfrontaUltraWS.ConfrontaUltraWebServiceServiceLocator;

@Configuration
public class WebServiceConfig {

	@Bean("confrontaUltraWebServiceServiceLocator")
	public ConfrontaUltraWebServiceServiceLocator getServiceLocatior() {
		return new ConfrontaUltraWebServiceServiceLocator(
				"https://cifinpruebas.asobancaria.com/cifin/confrontav2plusws/services/ConfrontaUltraWS?wsdl");
	}
	
	@Bean("confrontaUltraWSSoapBindingStub")
	public ConfrontaUltraWSSoapBindingStub getSoapBindingStub(
			@Qualifier("confrontaUltraWebServiceServiceLocator") ConfrontaUltraWebServiceServiceLocator locator)
			throws ServiceException {
		return (ConfrontaUltraWSSoapBindingStub) locator.getConfrontaUltraWS();
	}
}
