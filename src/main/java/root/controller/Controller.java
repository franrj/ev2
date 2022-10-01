/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package root.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import root.model.dao.ClienteJpaController;
import root.model.entities.Cliente;

/**
 *
 * @author Fran
 */
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String test = request.getParameter("accion"); //auxiliar
        
        //datos recuperados del formulario
        String strId = request.getParameter("id");
        String strNombre = request.getParameter("nombre");
        String strApellido = request.getParameter("apellido");
        String strEdad = request.getParameter("edad");
        String StrCorreo = request.getParameter("correo");

        switch (test) {
            case "enviar":

                //entitiy
                Cliente cl = new Cliente();
                cl.setId(Integer.parseInt(strId));
                cl.setNombre(strNombre);
                cl.setApellido(strApellido);
                cl.setEdad(Integer.parseInt(strEdad));
                cl.setCorreo(StrCorreo);

                //dao
                ClienteJpaController dao = new ClienteJpaController();
                try {
                    dao.create(cl);
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                //salida
                request.getRequestDispatcher("resultado.jsp").forward(request, response);

                break;
            case "editar":
                
                //entity
                Cliente clEdit = new Cliente();
                clEdit.setId(Integer.parseInt(strId));
                clEdit.setNombre(strNombre);
                clEdit.setApellido(strApellido);
                clEdit.setEdad(Integer.parseInt(strEdad));
                clEdit.setCorreo(StrCorreo);

                //dao
                ClienteJpaController daoEdit = new ClienteJpaController();
                try {
                    daoEdit.edit(clEdit);
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                //salida
                request.getRequestDispatcher("resultado.jsp").forward(request, response);

                break;
            case "borrar":

                
                //dao
                ClienteJpaController daoBorrar = new ClienteJpaController();
                try {
                    daoBorrar.destroy(Integer.parseInt(strId));
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                //salida
                request.getRequestDispatcher("resultado.jsp").forward(request, response);

                break;

        }

    }

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
