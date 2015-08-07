package org.abcgo.service.logic;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ParseService {
	
	private final Logger log = LoggerFactory.getLogger(ParseService.class);
	
	@Inject
	private RestTemplate parseRestTemplate; 
	
	@Inject
	private HttpEntity<String> parseHttpEntity;
	
	public String findAllArea() {
		String url = "https://api.parse.com/1/classes/area";
		log.debug(String.format("URL=%s", url));
    	ResponseEntity<String> response = parseRestTemplate.exchange(url, HttpMethod.GET, parseHttpEntity, String.class);
    	return response.getBody();
	}

}
