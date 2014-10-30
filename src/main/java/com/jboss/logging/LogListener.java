package com.jboss.logging;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * Application Lifecycle Listener implementation class LogListener
 *
 */
public class LogListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public LogListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		URL log4jXml = Thread.currentThread().getContextClassLoader()
				.getResource("/log4j.xml");
		if (log4jXml == null)
			throw new IllegalStateException(
					"Application Specific log4j.xml not found");
		DOMConfigurator.configure(log4jXml);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

}
