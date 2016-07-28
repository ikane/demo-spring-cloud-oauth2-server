package org.ikane.config;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
@EnableResourceServer
@RestController
public class ResourceServerConfiguration /* extends ResourceServerConfigurerAdapter */{

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public Principal getLoggedUser(Principal user) {
		return user;
	}
}
