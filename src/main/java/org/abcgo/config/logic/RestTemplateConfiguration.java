package org.abcgo.config.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate parseRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	@Bean
	public HttpEntity<String> parseHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Parse-Application-Id", "LOcvyGh9msyjVPK8o3EnfK7yrQesrlG657pbBk6u");
		headers.add("X-Parse-REST-API-Key", "zLOVjKK8Zo8kmFwpSBAUIqS4fuORSKx5i4Nn6RC0");
		headers.add("Content-Type", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
		return httpEntity;
	}
}
