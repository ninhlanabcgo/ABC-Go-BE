package org.abcgo.web.rest.logic;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.abcgo.service.logic.ParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing parse.
 */
@RestController
@RequestMapping("/api")
public class ParseResource {
	
	private final Logger log = LoggerFactory.getLogger(ParseResource.class);
	
	@Inject
	private ParseService parseService;
	
    @RequestMapping(value = "/data/{uri}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getData(@PathVariable String uri) {
        return parseService.getDataAdmin(uri);
    }	
    
    @RequestMapping(value = "/data/admin/{uri}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDataAdmin(@PathVariable String uri) {
        return parseService.getDataAdmin(uri);
    }    
    
    @RequestMapping(value = "/data/admin/{uri}",
            method = { RequestMethod.POST, RequestMethod.PUT },
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUpdateDataAdmin(@PathVariable String uri, @RequestBody String data, HttpServletRequest request) {
        return parseService.createUpdateDataAdmin(uri, data, request.getMethod());
    }
    
    @RequestMapping(value = "/data/admin/{uri}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteDataAdmin(@PathVariable String uri) {
        return parseService.getDataAdmin(uri);
    }  
}
