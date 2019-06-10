package co.transunion.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.annotation.PostConstruct;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asobancaria.cifin.infocomercial.InformacionComercialSoapBindingStub;
import com.asobancaria.cifin.infocomercial.dto.ParametrosConsultaDTO;

import co.transunion.dto.SecurityDto;
import co.transunion.service.IComercialInformationService;

@Service
public class ComercialInformationService implements IComercialInformationService {

	@Autowired
	InformacionComercialSoapBindingStub informacionComercialSoapBindingStub;

	@PostConstruct
	public void init() {
		
	}

	@Override
	public String getComercialInformation(ParametrosConsultaDTO parameters, SecurityDto security)
			throws JSONException, IOException {
		File first = new File(getClass().getClassLoader().getResource("client-config.wsdd").toString());
		System.out.println(getClass().getClassLoader().getResource("client-config.wsdd").toString());
		if(first.delete()) {
			System.out.println("File deleted successfully"); 
		} else {
			System.out.println("Failed to delete the file");
		}
		;
		File source = new File("src/main/resources/two-client-config.wsdd");
        File dest = new File("src/main/resources/client-config.wsdd");
        Files.copy(source.toPath(), dest.toPath());
		informacionComercialSoapBindingStub.setUsername(security.getUser());
		informacionComercialSoapBindingStub.setPassword(security.getPassword());
		JSONObject xmlJSONObj = XML.toJSONObject(informacionComercialSoapBindingStub.consultaXml(parameters));
		return xmlJSONObj.toString(4);
	}

}
