package co.transunion.error.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.transunion.error.dto.ResponseRestService;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseRestService> handleAllExceptions(Exception ex, WebRequest request) {
		System.out.println(
				"**************************Mensaje Controlado por aspecto (ExceptionHandler)*******************************************");
		ex.printStackTrace();
		System.out.println("*********************************************************************");
		ResponseRestService errorDetails = new ResponseRestService<>(
				((ServletWebRequest) request).getRequest().getMethod(),
				((ServletWebRequest) request).getRequest().getRequestURL().toString(),
				SecurityContextHolder.getContext().getAuthentication().getName(), ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}