/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi417
 */
@WebServlet(name = "ControleurMain", urlPatterns = {"/ControleurMain"})
public class ControleurMain extends HttpServlet {

    private HashMap<String, Test> mp;

    
    @Override
    public void init(ServletConfig config) throws ServletException { // INSERT CODE ===> Override Method
        super.init(config); 
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<list");
        mp= new HashMap<>();

        Enumeration<String> liste = config.getInitParameterNames();
        while (liste.hasMoreElements()) {
            try {
               String nom = liste.nextElement();
               String section = config.getInitParameter(nom);
                Test classe = (Test) Class.forName(section).newInstance();
                mp.put(nom, classe);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleurMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ControleurMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ControleurMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String section = request.getParameter("section");

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<section");
        System.out.println(section);
        if (mp.containsKey(section)) {
            mp.get(section).persister();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
