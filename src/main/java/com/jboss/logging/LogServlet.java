package com.jboss.logging;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = Logger.getLogger(LogServlet.class);
	
	private static final String DEBUG = "DEBUG";
	private static final String INFO = "INFO";
	private static final String ERROR = "ERROR";
	private static final String TRACE = "TRACE";
	private static final String FATAL = "FATAL";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String logLevel = request.getParameter("logLevel");
		String logMessage = request.getParameter("logMessage");
		
		out.println("<html><head><title>Logging App</title></head><body>");
		out.println("[" + logLevel + "]   " + logMessage);
		
		if(logLevel.equalsIgnoreCase(DEBUG)) {
			logger.debug(logMessage);
		}
		else if(logLevel.equalsIgnoreCase(INFO)) {
			logger.info(logMessage);
		}
		else if(logLevel.equalsIgnoreCase(ERROR)) {
			logger.error(logMessage);
		}
		else if(logLevel.equalsIgnoreCase(TRACE)) {
			logger.trace(logMessage);
		}
		else if(logLevel.equalsIgnoreCase(FATAL)) {
			logger.fatal(logMessage);
		}
		
		out.println("<br><br><br><a href=\"index.jsp\">Try again</a></body></html>");		
	}
}
