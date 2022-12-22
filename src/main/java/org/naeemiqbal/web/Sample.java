package org.naeemiqbal.web;


import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

/*
@RestController
@EnableAutoConfiguration
public class Sample {
    
    @RequestMapping("/")
    public String salaam(){
        return "Assalamu Alaikum Naeem. " + new Date();
    }
    
    @RequestMapping("/hi")
    public String hello(){
        return "Hello Naeem. " + new Date();
    }       
}
/*/

@RestController
@RequestMapping("/salaam")
public class Sample {

	@GetMapping ()
	public String get() {
		return "Assalamu Aliakum";	
	}	

/*	@PostMapping
	public String post(@BodyVariable("data") String p) {
		return "Assalamu Aliakum" + p;	
	}
*/	
	@PostMapping
	public String post(@RequestBody String p) throws URISyntaxException {
		String s = 		UriUtils.decode(p, "UTF-8");
		return "Assalamu Aliakum decoded" + s;	
	}		
	
}
