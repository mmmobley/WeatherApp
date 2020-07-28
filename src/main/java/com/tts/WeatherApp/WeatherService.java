package com.tts.WeatherApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	 public void save(ZipCode zipCode) {
	    	
	       zipCodeRepository.save(zipCode);
	    } 
	    
	    public Response getForecast(String zipCode) {
	        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
	            zipCode + "&units=imperial&appid=" + apiKey;
	        RestTemplate restTemplate = new RestTemplate();
	                
	        try {
	        	
//	        	zipCodeRepository.save(zipCode);
	            return restTemplate.getForObject(url, Response.class);
	        }
	        catch (HttpClientErrorException ex) {
	            Response response = new Response();
	            response.setName("error");
	            return response;
	        }
	    }

	    public List<ZipCode> findTop10ByOrderByCreatedAtDesc(){
	    	return (List<ZipCode>) zipCodeRepository.findTop10ByOrderByCreatedAtDesc();
	    	
	    	
	    }
}
