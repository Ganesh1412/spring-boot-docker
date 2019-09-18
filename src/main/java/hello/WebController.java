package hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.util.Random;
import org.springframework.util.LinkedMultiValueMap;
import java.net.*;
import org.springframework.util.MultiValueMap;
import java.io.*;
import org.springframework.http.MediaType;


import hello.SampleResponse;

@RestController
public class WebController {
		
        SampleResponse response = new SampleResponse();
        Random rand = new Random();

	@RequestMapping(value = "/api1", method = RequestMethod.POST, consumes = "application/json")
	public SampleResponse response_without_header(@RequestBody String message) throws URISyntaxException
	{
		String message1 = message; 
    		RestTemplate restTemplate = new RestTemplate();
     
    		String baseUrl = "http://localhost:8084/reverse";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

    		URI uri = new URI(baseUrl);
		HttpEntity<String> entity = new HttpEntity<String>(message1,headers);
		String result = restTemplate.postForObject(baseUrl, entity, String.class);
		System.out.println("The reverse valu : " + result);
		response.setId(rand.nextDouble());
                response.setMessage(result);
                return response;
     
 
	}



}
