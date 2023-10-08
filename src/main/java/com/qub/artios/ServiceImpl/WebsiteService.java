package com.qub.artios.ServiceImpl;

import com.qub.artios.Repo.WebsiteRepository;
import com.qub.artios.controller.ArtiosWebScrappedController;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@Service
public class WebsiteService implements WebsiteRepository {
	
	private static final Logger log= LoggerFactory.getLogger(WebsiteService.class);
	
	/* define a constant value 
	 * for DEFAULT_URL */
	public static final String DEFAULT_URL = "https://www.qub.ac.uk/schools/eeecs/News/";
	
	/*
	 * Method to connect and Fetch the 
	 * source code of the URL
	 */
	public Document connectAndFetchSourceCode(String url) {
		if(null==url) {
			url = DEFAULT_URL;
		}
		Document doc =null;
		try {
			doc = Jsoup.connect(url).get();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			System.out.println("Fetching completed");
		}
		return doc;
		
	}
	
	/* Method to fetch the title 
	 * of the URL */
    public String title(String url) {
    	Document doc = connectAndFetchSourceCode(url);
    	return doc.title();
    	
    }
    
	/*
	 * Method used to print the
	 *  content with index
	 */
	
	public void hrefTag(String url) {
		Document doc = connectAndFetchSourceCode(url);
		Elements elements = doc.getElementsByTag("a");
		List<String> contents = new ArrayList<>();
		String cnt = null;
		int j=0;
		for(int i=1; i<= elements.size()-1; i++) {
			//String link = elements.get(i).attr("href");
			cnt = elements.get(i).text();
			if(cnt.length()!=0) {
				contents.add(cnt);
			}
			
			
		}
		for(String str: contents) {
			log.info(++j + " " + str);
		}
	}
	
	/*
	 * Method used to return the 
	 * content in JSON format
	 */
	
	public List<String> hrefTagJSON(String url) {
		Document doc = connectAndFetchSourceCode(url);
		Elements elements = doc.getElementsByTag("a");
		List<String> contents = new ArrayList<>();
		String cnt = null;
		int j=0;
		for(int i=1; i<= elements.size()-1; i++) {
			//String link = elements.get(i).attr("href");
			cnt = elements.get(i).text();
			if(cnt.length()!=0) {
				contents.add(cnt);
			}
			
			
		}
		return contents;
	}
	


}
