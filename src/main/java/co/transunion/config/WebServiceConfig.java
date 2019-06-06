package co.transunion.config;

import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.asobancaria.cifin.infocomercial.InformacionComercialSoapBindingStub;
import com.asobancaria.cifin.infocomercial.InformacionComercialWSServiceLocator;

import corp.universo.ttuweb3.cifin.confrontav2plusws.services.ConfrontaUltraWS.ConfrontaUltraWSSoapBindingStub;
import corp.universo.ttuweb3.cifin.confrontav2plusws.services.ConfrontaUltraWS.ConfrontaUltraWebServiceServiceLocator;

@Configuration
@PropertySources({ @PropertySource("classpath:configuration.properities") })
public class WebServiceConfig {
	
	@Value("${configurarion.service.cuestinario}")
	String urlServiceCuestionario;
	
	@Value("${configurarion.service.comercialInformation}")
	String urlServiceComercialInformation;

	@Bean("confrontaUltraWebServiceServiceLocator")
	public ConfrontaUltraWebServiceServiceLocator getServiceLocatior() {
		return new ConfrontaUltraWebServiceServiceLocator(urlServiceCuestionario);
	}
	
	@Bean("confrontaUltraWSSoapBindingStub")
	public ConfrontaUltraWSSoapBindingStub getSoapBindingStub(
			@Qualifier("confrontaUltraWebServiceServiceLocator") ConfrontaUltraWebServiceServiceLocator locator)
			throws ServiceException {
		locator.setEngineConfiguration(new FileProvider("client-config.wsdd"));
		return (ConfrontaUltraWSSoapBindingStub) locator.getConfrontaUltraWS();
	}
	
	@Bean("informacionComercialWSServiceLocator")
	public InformacionComercialWSServiceLocator getServiceinformationLocator() {
		return new InformacionComercialWSServiceLocator(urlServiceComercialInformation);
	}
	
	@Bean("informacionComercialSoapBindingStub")
	public InformacionComercialSoapBindingStub getSoapBindingInformationStub(
			@Qualifier("informacionComercialWSServiceLocator") InformacionComercialWSServiceLocator locator)
			throws ServiceException {
		locator.setEngineConfiguration(new FileProvider("client-config.wsdd"));
		return (InformacionComercialSoapBindingStub) locator.getInformacionComercial();
	}
	
	
}
