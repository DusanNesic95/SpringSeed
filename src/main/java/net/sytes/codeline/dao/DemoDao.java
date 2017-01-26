package net.sytes.codeline.dao;

import java.util.List;

import net.sytes.codeline.entities.Demo;

/**
 * @author Dusan Nesic
 * DAO layer with definition of demo method
 * used to communicate with the database
 */
public interface DemoDao {
	
	public Demo addDemo(Demo demo);
	
}
