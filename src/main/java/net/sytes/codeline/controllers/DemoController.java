package net.sytes.codeline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.codeline.dao.DemoDao;
import net.sytes.codeline.entities.Demo;

/**
 * @author Dusan Nesic
 * Defining REST Controller which contains methods
 * used via front-end application
 */
@RestController
public class DemoController {
	
	@Autowired
	private DemoDao demoDao;
	
	@RequestMapping(value = "/demometoda", method = RequestMethod.POST)
	public Demo addDemo(@RequestBody Demo demo) {
		return demoDao.addDemo(demo);
	}

}
