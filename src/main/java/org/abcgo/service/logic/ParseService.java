package org.abcgo.service.logic;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ParseService {
	
	private final Logger log = LoggerFactory.getLogger(ParseService.class);
	
	@Inject
	private RestTemplate parseRestTemplate;
	
	@Inject
	private HttpEntity<String> parseHttpEntity;
	
	@Inject
	private String parseRootURL;
	
	public String getDataAdmin(String uri) {
		uri = uri.replace("-", "/");
		String url = parseRootURL + uri;
    	ResponseEntity<String> response = parseRestTemplate.exchange(url, HttpMethod.GET, parseHttpEntity, String.class);
    	return response.getBody();
	}
	
	public String createUpdateDataAdmin(String uri, String data, String httpMethod) {
		uri = uri.replace("-", "/");
		String url = parseRootURL + uri;
		HttpMethod currentHttpMethod = HttpMethod.valueOf(httpMethod);
		HttpEntity<String> httpEntity = new HttpEntity<String>(data, parseHttpEntity.getHeaders());
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<HttpMessageConverter<?>>();
	    httpMessageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
	    restTemplate.setMessageConverters(httpMessageConverters);
	    ResponseEntity<String> response = restTemplate.exchange(url, currentHttpMethod, httpEntity, String.class);
	    return response.getBody();
	}
	
	public String deleteDataAdmin(String uri) {
		uri = uri.replace("-", "/");
		String url = parseRootURL + uri;
    	ResponseEntity<String> response = parseRestTemplate.exchange(url, HttpMethod.DELETE, parseHttpEntity, String.class);
    	return response.getBody();
	}	

}
