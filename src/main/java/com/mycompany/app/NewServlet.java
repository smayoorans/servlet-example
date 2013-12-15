/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mayooran
 */
public class NewServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        
        BodyMassIndex b = new BodyMassIndex();
        Double result = b.calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));

        if (result != null) {
            request.setAttribute("result", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
@Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
