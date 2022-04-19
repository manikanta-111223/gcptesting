package com.io.openapi.controllers.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.converter.HttpMessageNotReadableException;
import static com.io.openapi.util.Util.lookupErrorMessage;

@ControllerAdvice
public class AKCBreedsExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "";
		Map<String, String> exampleMap = new HashMap<>();
		exampleMap.put("application/json", "[{\"code\":\"ERR400\",\"title\":\"Bad Request\",\"id\":\"ERR400\",\"detail\":\"Please provide a valid input for group\",\"links\":[{\"type\":\"help\",\"href\":\"http://developer.domain.com/dir/ref\",\"description\":\"Link to the developer portal documentation.\"}]}]");
		if(request.getHeader("Accept") != null && exampleMap.keySet().contains(request.getHeader("Accept"))){
			error = exampleMap.get(request.getHeader("Accept"));
			headers.add("Content-Type", request.getHeader("Accept"));
		}else if(!exampleMap.isEmpty()){
			for(String key : exampleMap.keySet()){
				error = exampleMap.get(key);
				headers.add("Content-Type", key);
				break;
			}
		}
		return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
		
	}
		
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {String error = "";
		Map<String, String> exampleMap = new HashMap<>();
		exampleMap.put("application/json", "[{\"code\":\"ERR400\",\"title\":\"Bad Request\",\"id\":\"ERR400\",\"detail\":\"Please provide a valid input for group\",\"links\":[{\"type\":\"help\",\"href\":\"http://developer.domain.com/dir/ref\",\"description\":\"Link to the developer portal documentation.\"}]}]");
		if(request.getHeader("Accept") != null && exampleMap.keySet().contains(request.getHeader("Accept"))){
			error = exampleMap.get(request.getHeader("Accept"));
			headers.add("Content-Type", request.getHeader("Accept"));
		}else if(!exampleMap.isEmpty()){
			for(String key : exampleMap.keySet()){
				error = exampleMap.get(key);
				headers.add("Content-Type", key);
				break;
			}
		}
		return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
	}
	
	
}
