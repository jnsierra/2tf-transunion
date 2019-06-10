package co.transunion.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.cifin.confrontaultra.dto.ultra.CuestionarioULTRADTO;
import co.cifin.confrontaultra.dto.ultra.ParametrosSeguridadULTRADTO;
import co.cifin.confrontaultra.dto.ultra.ParametrosULTRADTO;
import co.transunion.service.ICuestionarioService;
import corp.universo.ttuweb3.cifin.confrontav2plusws.services.ConfrontaUltraWS.ConfrontaUltraWSSoapBindingStub;

@Service
public class CuestionarioService implements ICuestionarioService {
	
	@Autowired
	ConfrontaUltraWSSoapBindingStub confrontaUltraWSSoapBindingStub;
	
	@PostConstruct
	public void init() {
		
	}

	@Override	
	public CuestionarioULTRADTO getCuestionario(ParametrosULTRADTO parametros, ParametrosSeguridadULTRADTO security)
			throws IOException {
		File first = new File("src/main/resources/client-config.wsdd");
		if (first.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}
				File source = new File("src/main/resources/one-client-config.wsdd");
        File dest = new File("src/main/resources/client-config.wsdd");
        
        Files.copy(new File(source.getAbsolutePath()).toPath(), new File(dest.getAbsolutePath()).toPath());
		return confrontaUltraWSSoapBindingStub.obtenerCuestionario(security, parametros);
	}

}
