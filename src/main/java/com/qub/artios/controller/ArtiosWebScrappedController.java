package com.qub.artios.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qub.artios.ServiceImpl.WebsiteService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArtiosWebScrappedController {
	private static final Logger logger = LoggerFactory.getLogger(ArtiosWebScrappedController.class);
	
	@Autowired
	WebsiteService websiteService;
	
	/* Method used to convert the 
	 * HTTPServletRequest into appropriate URL */
	public String retrieveURL(HttpServletRequest request, int n) {
		String fullUrl = request.getRequestURL().toString();
		String url;
		if(n==1) {
			url = fullUrl.split("/title/")[1];
		    return url;
		}
		else if(n==2) {
			url = fullUrl.split("/json/")[1];
		    return url;
		}
		else {
			url = fullUrl.split("/print/")[1];
		    return url;
		}
	    
	}
	
	@GetMapping("/title/**")
	public String fetchTitle(HttpServletRequest request) {
		String url = retrieveURL(request, 1);
		logger.info("Fetching Title for URL: {}", url);
		String title = websiteService.title(url);
		return title;	
	}
	
	@GetMapping("/json/**")
	public List<String> fetchJSON(HttpServletRequest request){
		String url = retrieveURL(request, 2);
		logger.info("Fetching JSON....");
		return websiteService.hrefTagJSON(url);
	}
	
	@GetMapping("/print/**")
	public void printContent(HttpServletRequest request){
		String url = retrieveURL(request, 0);
		logger.info("Printing Contents....");
		websiteService.hrefTag(url);
	}

}
