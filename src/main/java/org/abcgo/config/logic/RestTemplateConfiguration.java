package org.abcgo.config.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration implements EnvironmentAware {
	
	private final Logger log = LoggerFactory.getLogger(RestTemplateConfiguration.class);
	
	private RelaxedPropertyResolver parsePropertyResolver;
	
    @Override
    public void setEnvironment(Environment environment) {
        this.parsePropertyResolver = new RelaxedPropertyResolver(environment, "parse.");
    }

	@Bean
	public RestTemplate parseRestTemplate() {
		log.debug("Initialize parse rest template");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}	
	
	@Bean
	public HttpEntity<String> parseHttpEntity() {
		log.debug("Initialize parse http entity");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.add("Accept", "application/json");
		httpHeaders.add("X-Parse-Application-Id", parsePropertyResolver.getProperty("application.id"));
		httpHeaders.add("X-Parse-REST-API-Key", parsePropertyResolver.getProperty("rest.api.key"));
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		return httpEntity;
	}
	
	@Bean
	public String parseRootURL() {
		log.debug("Initialize parse root url");
		String parseRootURL = parsePropertyResolver.getProperty("root.url");
		return parseRootURL;
	}
}
