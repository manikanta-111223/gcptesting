package com.io.openapi.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.io.openapi.enums.GroupEnum;
import com.io.openapi.models.Breed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AKCBreedsController {

	@GetMapping(value="/breeds", produces={ "application/json", "application/xml" })
    public ResponseEntity<Object> getBreed(@RequestParam("group") GroupEnum group, @RequestParam("origin_country") String origin_country, @RequestHeader Map<String, String> headers){
      
      	HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("API-Version", "Value-API-Version");
		responseHeaders.set("Correlation-Key", "Value-Correlation-Key");
      	String response = "";
		Map<String, String> mediaTypesExampleMap = new HashMap<>();
		mediaTypesExampleMap.put("application/json","[{\"id\":\"13858483\",\"friendly-id\":\"australian-cattle-dog\",\"breed\":\"Australian Cattle Dog\",\"group\":\"herding\"},{\"id\":\"43338085\",\"friendly-id\":\"australian-shepherd\",\"breed\":\"Australian Shepherd\",\"group\":\"herding\"},{\"id\":\"44471185\",\"friendly-id\":\"bearded-collie\",\"breed\":\"Bearded Collie\",\"group\":\"herding\"},{\"id\":\"91265325\",\"friendly-id\":\"beauceron\",\"breed\":\"Beauceron\",\"group\":\"herding\"}]");

		mediaTypesExampleMap.put("application/xml","<?xml version=\"1.0\" encoding=\"UTF-8\" ?><root><row><id>13858483</id><friendly-id>australian-cattle-dog</friendly-id><breed>Australian Cattle Dog</breed><group>herding</group></row><row><id>43338085</id><friendly-id>australian-shepherd</friendly-id><breed>Australian Shepherd</breed><group>herding</group></row><row><id>44471185</id><friendly-id>bearded-collie</friendly-id><breed>Bearded Collie</breed><group>herding</group></row><row><id>91265325</id><friendly-id>beauceron</friendly-id><breed>Beauceron</breed><group>herding</group></row></root>");

		if (headers.containsKey("accept")) {
			if (!mediaTypesExampleMap.isEmpty() && mediaTypesExampleMap.containsKey(headers.get("accept"))) {
				response = mediaTypesExampleMap.get(headers.get("accept"));
				responseHeaders.set(HttpHeaders.CONTENT_TYPE, headers.get("accept"));
			} else if (!mediaTypesExampleMap.isEmpty()) {
				Optional<String> firstKey = mediaTypesExampleMap.keySet().stream().findFirst();
				if (firstKey.isPresent()) {
					response = mediaTypesExampleMap.get(firstKey.get());
					responseHeaders.set(HttpHeaders.CONTENT_TYPE,firstKey.get() );
				}
			}
		} else {
			if (!mediaTypesExampleMap.isEmpty()) {
				Optional<String> firstKey = mediaTypesExampleMap.keySet().stream().findFirst();
				if (firstKey.isPresent()) {
					response = mediaTypesExampleMap.get(firstKey.get());
					responseHeaders.set(HttpHeaders.CONTENT_TYPE,firstKey.get() );
				}
			}
		}
		return ResponseEntity.ok().headers(responseHeaders).body(response);
        
        
    }
    
	@PostMapping(value="/breeds", produces={ "application/json" })
    public ResponseEntity<Object> createBreed(@Valid @RequestBody Breed breed, @RequestHeader Map<String, String> headers){
      
      	HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("API-Version", "Value-API-Version");
		responseHeaders.set("Correlation-Key", "Value-Correlation-Key");
		responseHeaders.set("Location", "Value-Location");
      	String response = "";
		Map<String, String> mediaTypesExampleMap = new HashMap<>();
		List<Breed> breedList = new ArrayList<>();
		breedList.add(breed);
		return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeaders).body(breedList);
        
        
    }
    
	@GetMapping(value="/breeds/{friendly_id}", produces={ "application/json" })
    public ResponseEntity<Object> getOneBreed(@PathVariable String friendly_id, @RequestHeader Map<String, String> headers){
      
      	HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("API-Version", "Value-API-Version");
		responseHeaders.set("Correlation-Key", "Value-Correlation-Key");
		responseHeaders.set("Location", "Value-Location");
      	String response = "";
		Map<String, String> mediaTypesExampleMap = new HashMap<>();
		
		if(headers.get("accept").equals("application/json")){
			response="{}";
		}
		else if(headers.get("accept").equals("application/xml")){
			response="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		} else {
			response="ok";
		}
			return ResponseEntity.ok().headers(responseHeaders).body(response);
        
        
    }
    
	@PutMapping(value="/breeds/{friendly_id}", produces={ "application/json" })
    public ResponseEntity<Object> updateOneBreed(@PathVariable String friendly_id,  @Valid @RequestBody Breed breed, @RequestHeader Map<String, String> headers){
      
      	HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("API-Version", "Value-API-Version");
		responseHeaders.set("Correlation-Key", "Value-Correlation-Key");
		responseHeaders.set("Location", "Value-Location");
      	String response = "";
		Map<String, String> mediaTypesExampleMap = new HashMap<>();
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(breed);
        
        
    }
    
	@DeleteMapping(value="/breeds/{id}", produces={ "*/*" })
    public ResponseEntity<Object> deleteOneBreed(@PathVariable String id, @RequestHeader Map<String, String> headers){
      
      	HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("API-Version", "Value-API-Version");
		responseHeaders.set("Correlation-Key", "Value-Correlation-Key");
      	String response = "";
		Map<String, String> mediaTypesExampleMap = new HashMap<>();
		return ResponseEntity.noContent().headers(responseHeaders).build();
        
        
    }
    
    	
}
