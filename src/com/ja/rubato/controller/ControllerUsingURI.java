package com.ja.rubato.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ja.rubato.controller.command.*;
import com.ja.rubato.controller.*;

/**
 * Servlet implementation class ControllerUsingURI
 */
//@WebServlet("/ControllerUsingURI") Web.xml에서 설정들어감 
public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandFactory commandfactory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUsingURI() {
        super();
        commandfactory = new CommandFactory();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		command = command.substring(request.getContextPath().length());
		System.out.println("넘어온 명령어 :" + command);
		CommandHandler handler = commandfactory.getCommandHandler(command);
		String view = null;
		if (handler != null) { 
			view = handler.process(request, response);
		} else {
		 
			System.out.println("[경고] 명령어에 매핑된 객체가 없습니다.");
		}
		if (view != null) {	
			if (view.startsWith("redirect:")) { 
				view = view.substring("redirect:".length()); 		
				response.sendRedirect(view);
			} else {	
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
		}

	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}