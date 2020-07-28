package com.tts.WeatherApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	   @GetMapping
	    public String getIndex(Model model) {
	    	List<ZipCode> zipcodes = weatherService.findTop10ByOrderByCreatedAtDesc();
		    model.addAttribute("zipCodeList", zipcodes);
	        model.addAttribute("request", new Request());
	        return "index";
	    }
	    
	    @PostMapping
	    public String postIndex(Request request, Model model) {
	        Response data = weatherService.getForecast(request.getZipCode());
	        ZipCode zipCode = new ZipCode();
	        zipCode.setZipCode(request.getZipCode());
	        weatherService.save(zipCode);
	        List<ZipCode> zipcodes = weatherService.findTop10ByOrderByCreatedAtDesc();
		    model.addAttribute("zipCodeList", zipcodes);
	        model.addAttribute("data", data);
	        return "index";
	    }

	
}

