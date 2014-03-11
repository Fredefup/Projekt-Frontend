/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import commands.Command;
import commands.LogoutCommand;
import commands.ShowLoginCommand;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmed Sadiq
 */
@WebServlet(name = "FrontController", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet
{
  private int PORT_NON_SSL;
  private int PORT_SSL;
   

    public FrontController()
    {
	
    }
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String cmdStr = request.getParameter("command");
    cmdStr = cmdStr!=null ? cmdStr: "main";
    Command command = Factory.getInstance().getCommand(cmdStr,request);
    String path = command.execute(request);
    
    if (command instanceof ShowLoginCommand && !request.isSecure()) {
      String SSL = "https://" + request.getServerName() + ":" + PORT_SSL + request.getRequestURI() + "?command=showlogin";
      System.out.println("SSL redirect: " + SSL);
      response.sendRedirect(SSL);
    } else if (command instanceof LogoutCommand) {
      String nonSSL = "http://" + request.getServerName() + ":" + PORT_NON_SSL + request.getRequestURI();
      System.out.println("Non SSL redirect: " + nonSSL);
      response.sendRedirect(nonSSL);
    } 
    else {
      request.getRequestDispatcher(path).forward(request, response);
    }
    

  }

  @Override
  public void init() throws ServletException {
    PORT_NON_SSL = Integer.parseInt(getServletContext().getInitParameter("portNonSSL"));
    PORT_SSL = Integer.parseInt(getServletContext().getInitParameter("portSSL"));
  }
    

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//    {
//	
//	String key = req.getParameter("command");
//	Command command = Factory.getInstance().getCommand(key);
//	String target = command.execute(req);
//	RequestDispatcher dispt = req.getRequestDispatcher(target);
//	dispt.forward(req, resp);
//    }
  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
