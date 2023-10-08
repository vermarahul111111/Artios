package com.qub.artios.Repo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository {
	
	public String title(String url);
	
	public void hrefTag(String url);
	
	public List<String> hrefTagJSON(String url);
	
}
